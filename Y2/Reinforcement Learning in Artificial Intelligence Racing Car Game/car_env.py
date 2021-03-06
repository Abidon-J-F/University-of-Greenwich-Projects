"""
Environment for 2D car driving.

Inspiration was based on [莫烦Python] : https://morvanzhou.github.io/tutorials/


Requirement:
pyglet >= 1.2.4
numpy >= 1.12.1
"""
import numpy as np
import pyglet


#pyglet.clock.set_fps_limit(10000)

#car settings
class CarEnv(object):
    n_sensor = 5
    action_dim = 1
    state_dim = n_sensor
    viewer = None
    viewer_xy = (1366, 768)
    sensor_max = 150.
    start_point = [1100, 300]
    speed = 55.
    dt = 0.1

    def __init__(self, discrete_action=False):
        self.is_discrete_action = discrete_action
        if discrete_action:
            self.actions = [-1, 0, 1]
        else:
            self.action_bound = [-1, 1]

        self.terminal = False
        # node1 (x, y, r, w, l),
        self.car_info = np.array([0, 0, 0, 20, 40], dtype=np.float64)   # car coordination
        self.obstacle1_coords = np.array([
            [0, 668],
            [0, 768],
            [400, 768],
            [400, 668],
        ])
        self.obstacle2_coords = np.array([
            [320, 550],
            [320, 768],
            [450, 768],
            [450, 550],
        ])
        self.obstacle3_coords = np.array([
            [880, 600],
            [880, 768],
            [1366, 768],
            [1366, 600],
        ])
        self.obstacle4_coords = np.array([
            [1150, 0],
            [1150, 600],
            [1366, 600],
            [1366, 0],
        ])
        self.obstacle5_coords = np.array([
            [130, 450],
            [130, 550],
            [200, 550],
            [200, 450],
        ])
        self.obstacle6_coords = np.array([
            [120, 120],
            [120, 450],
            [1020, 450],
            [1020, 120],
        ])
        self.obstacle7_coords = np.array([
            [570, 450],
            [570, 650],
            [750, 650],
            [750, 450],
        ])
        self.sensor_info = self.sensor_max + np.zeros((self.n_sensor, 3))  # n sensors, (distance, end_x, end_y)

    def step(self, action):
        if self.is_discrete_action:
            action = self.actions[action]
        else:
            action = np.clip(action, *self.action_bound)[0]
        self.car_info[2] += action * np.pi/30  # max r = 6 degree
        self.car_info[:2] = self.car_info[:2] + \
                            self.speed * self.dt * np.array([np.cos(self.car_info[2]), np.sin(self.car_info[2])])

        self._update_sensor()
        s = self._get_state()
        r = -1 if self.terminal else 0
        return s, r, self.terminal

    def reset(self):
        self.terminal = False
        self.car_info[:3] = np.array([*self.start_point, -np.pi/2])
        self._update_sensor()
        return self._get_state()

    def render(self):
        if self.viewer is None:
            self.viewer = Viewer(*self.viewer_xy, self.car_info, self.sensor_info, self.obstacle1_coords,
                                 self.obstacle2_coords, self.obstacle3_coords, self.obstacle4_coords, self.obstacle5_coords, self.obstacle6_coords, self.obstacle7_coords)
        self.viewer.render()

    def sample_action(self):
        if self.is_discrete_action:
            a = np.random.choice(list(range(3)))
        else:
            a = np.random.uniform(*self.action_bound, size=self.action_dim)
        return a

    def _get_state(self):
        s = self.sensor_info[:, 0].flatten()/self.sensor_max
        return s

    def _update_sensor(self):
        cx, cy, rotation = self.car_info[:3]

        n_sensors = len(self.sensor_info)
        sensor_theta = np.linspace(-np.pi / 2, np.pi / 2, n_sensors)
        xs = cx + (np.zeros((n_sensors, ))+self.sensor_max) * np.cos(sensor_theta)
        ys = cy + (np.zeros((n_sensors, ))+self.sensor_max) * np.sin(sensor_theta)
        xys = np.array([[x, y] for x, y in zip(xs, ys)])    # shape (5 sensors, 2)

        # sensors
        tmp_x = xys[:, 0] - cx
        tmp_y = xys[:, 1] - cy
        # apply rotation
        rotated_x = tmp_x * np.cos(rotation) - tmp_y * np.sin(rotation)
        rotated_y = tmp_x * np.sin(rotation) + tmp_y * np.cos(rotation)
        # rotated x y
        self.sensor_info[:, -2:] = np.vstack([rotated_x+cx, rotated_y+cy]).T

        q = np.array([cx, cy])
        for si in range(len(self.sensor_info)):
            s = self.sensor_info[si, -2:] - q
            possible_sensor_distance = [self.sensor_max]
            possible_intersections = [self.sensor_info[si, -2:]]

            # obstacle collision
            for oi in range(len(self.obstacle1_coords)):
                p = self.obstacle1_coords[oi]
                r = self.obstacle1_coords[(oi + 1) % len(self.obstacle1_coords)] - self.obstacle1_coords[oi]
                if np.cross(r, s) != 0:  # may collision
                    t = np.cross((q - p), s) / np.cross(r, s)
                    u = np.cross((q - p), r) / np.cross(r, s)
                    if 0 <= t <= 1 and 0 <= u <= 1:
                        intersection = q + u * s
                        possible_intersections.append(intersection)
                        possible_sensor_distance.append(np.linalg.norm(u*s))

            for oi in range(len(self.obstacle2_coords)):
                p = self.obstacle2_coords[oi]
                r = self.obstacle2_coords[(oi + 1) % len(self.obstacle2_coords)] - self.obstacle2_coords[oi]
                if np.cross(r, s) != 0:  # may collision
                    t = np.cross((q - p), s) / np.cross(r, s)
                    u = np.cross((q - p), r) / np.cross(r, s)
                    if 0 <= t <= 1 and 0 <= u <= 1:
                        intersection = q + u * s
                        possible_intersections.append(intersection)
                        possible_sensor_distance.append(np.linalg.norm(u*s))

            for oi in range(len(self.obstacle3_coords)):
                p = self.obstacle3_coords[oi]
                r = self.obstacle3_coords[(oi + 1) % len(self.obstacle3_coords)] - self.obstacle3_coords[oi]
                if np.cross(r, s) != 0:  # may collision
                    t = np.cross((q - p), s) / np.cross(r, s)
                    u = np.cross((q - p), r) / np.cross(r, s)
                    if 0 <= t <= 1 and 0 <= u <= 1:
                        intersection = q + u * s
                        possible_intersections.append(intersection)
                        possible_sensor_distance.append(np.linalg.norm(u*s))

            for oi in range(len(self.obstacle4_coords)):
                p = self.obstacle4_coords[oi]
                r = self.obstacle4_coords[(oi + 1) % len(self.obstacle4_coords)] - self.obstacle4_coords[oi]
                if np.cross(r, s) != 0:  # may collision
                    t = np.cross((q - p), s) / np.cross(r, s)
                    u = np.cross((q - p), r) / np.cross(r, s)
                    if 0 <= t <= 1 and 0 <= u <= 1:
                        intersection = q + u * s
                        possible_intersections.append(intersection)
                        possible_sensor_distance.append(np.linalg.norm(u*s))

            for oi in range(len(self.obstacle5_coords)):
                p = self.obstacle5_coords[oi]
                r = self.obstacle5_coords[(oi + 1) % len(self.obstacle5_coords)] - self.obstacle5_coords[oi]
                if np.cross(r, s) != 0:  # may collision
                    t = np.cross((q - p), s) / np.cross(r, s)
                    u = np.cross((q - p), r) / np.cross(r, s)
                    if 0 <= t <= 1 and 0 <= u <= 1:
                        intersection = q + u * s
                        possible_intersections.append(intersection)
                        possible_sensor_distance.append(np.linalg.norm(u*s))

            for oi in range(len(self.obstacle6_coords)):
                p = self.obstacle6_coords[oi]
                r = self.obstacle6_coords[(oi + 1) % len(self.obstacle6_coords)] - self.obstacle6_coords[oi]
                if np.cross(r, s) != 0:  # may collision
                    t = np.cross((q - p), s) / np.cross(r, s)
                    u = np.cross((q - p), r) / np.cross(r, s)
                    if 0 <= t <= 1 and 0 <= u <= 1:
                        intersection = q + u * s
                        possible_intersections.append(intersection)
                        possible_sensor_distance.append(np.linalg.norm(u*s))

            for oi in range(len(self.obstacle7_coords)):
                p = self.obstacle7_coords[oi]
                r = self.obstacle7_coords[(oi + 1) % len(self.obstacle7_coords)] - self.obstacle7_coords[oi]
                if np.cross(r, s) != 0:  # may collision
                    t = np.cross((q - p), s) / np.cross(r, s)
                    u = np.cross((q - p), r) / np.cross(r, s)
                    if 0 <= t <= 1 and 0 <= u <= 1:
                        intersection = q + u * s
                        possible_intersections.append(intersection)
                        possible_sensor_distance.append(np.linalg.norm(u*s))

            # window collision
            win_coord = np.array([
                [0, 0],
                [self.viewer_xy[0], 0],
                [*self.viewer_xy],
                [0, self.viewer_xy[1]],
                [0, 0],
            ])
            for oi in range(4):
                p = win_coord[oi]
                r = win_coord[(oi + 1) % len(win_coord)] - win_coord[oi]
                if np.cross(r, s) != 0:  # may collision
                    t = np.cross((q - p), s) / np.cross(r, s)
                    u = np.cross((q - p), r) / np.cross(r, s)
                    if 0 <= t <= 1 and 0 <= u <= 1:
                        intersection = p + t * r
                        possible_intersections.append(intersection)
                        possible_sensor_distance.append(np.linalg.norm(intersection - q))

            distance = np.min(possible_sensor_distance)
            distance_index = np.argmin(possible_sensor_distance)
            self.sensor_info[si, 0] = distance
            self.sensor_info[si, -2:] = possible_intersections[distance_index]
            if distance < self.car_info[-1]/2:
                self.terminal = True


class Viewer(pyglet.window.Window):
    color = {
        'background': [1]*3 + [1]
    }
    #fps_display = pyglet.clock.ClockDisplay()
    bar_thc = 5

    def __init__(self, width, height, car_info, sensor_info, obstacle1_coords, obstacle2_coords, obstacle3_coords, obstacle4_coords, obstacle5_coords, obstacle6_coords, obstacle7_coords):
        super(Viewer, self).__init__(width, height, resizable=False, caption='2D car', vsync=False)  # vsync=False to not use the monitor FPS
        self.set_location(x=80, y=10)
        pyglet.gl.glClearColor(*self.color['background'])

        self.car_info = car_info
        self.sensor_info = sensor_info

        self.batch = pyglet.graphics.Batch()
        background = pyglet.graphics.OrderedGroup(0)
        foreground = pyglet.graphics.OrderedGroup(1)

        self.sensors = []
        line_coord = [0, 0] * 2
        c = (73, 73, 73) * 2
        for i in range(len(self.sensor_info)):
            self.sensors.append(self.batch.add(2, pyglet.gl.GL_LINES, foreground, ('v2f', line_coord), ('c3B', c)))

        car_box = [0, 0] * 4
        c = (249, 86, 86) * 4
        self.car = self.batch.add(4, pyglet.gl.GL_QUADS, foreground, ('v2f', car_box), ('c3B', c))

        c = (134, 181, 244) * 4
        self.obstacle1 = self.batch.add(4, pyglet.gl.GL_QUADS, background, ('v2f', obstacle1_coords.flatten()),
                                        ('c3B', c))
        self.obstacle2 = self.batch.add(4, pyglet.gl.GL_QUADS, background, ('v2f', obstacle2_coords.flatten()),
                                        ('c3B', c))
        self.obstacle3 = self.batch.add(4, pyglet.gl.GL_QUADS, background, ('v2f', obstacle3_coords.flatten()),
                                        ('c3B', c))
        self.obstacle4 = self.batch.add(4, pyglet.gl.GL_QUADS, background, ('v2f', obstacle4_coords.flatten()),
                                        ('c3B', c))
        self.obstacle5 = self.batch.add(4, pyglet.gl.GL_QUADS, background, ('v2f', obstacle5_coords.flatten()),
                                        ('c3B', c))
        self.obstacle6 = self.batch.add(4, pyglet.gl.GL_QUADS, background, ('v2f', obstacle6_coords.flatten()),
                                        ('c3B', c))
        self.obstacle7 = self.batch.add(4, pyglet.gl.GL_QUADS, background, ('v2f', obstacle7_coords.flatten()),
                                        ('c3B', c))

    def render(self):
        pyglet.clock.tick()
        self._update()
        self.switch_to()
        self.dispatch_events()
        self.dispatch_event('on_draw')
        self.flip()

    def on_draw(self):
        self.clear()
        self.batch.draw()
        # self.fps_display.draw()

    def _update(self):
        cx, cy, r, w, l = self.car_info

        # sensors
        for i, sensor in enumerate(self.sensors):
            sensor.vertices = [cx, cy, *self.sensor_info[i, -2:]]

        # car
        xys = [
            [cx + l / 2, cy + w / 2],
            [cx - l / 2, cy + w / 2],
            [cx - l / 2, cy - w / 2],
            [cx + l / 2, cy - w / 2],
        ]
        r_xys = []
        for x, y in xys:
            tempX = x - cx
            tempY = y - cy
            # apply rotation
            rotatedX = tempX * np.cos(r) - tempY * np.sin(r)
            rotatedY = tempX * np.sin(r) + tempY * np.cos(r)
            # rotated x y
            x = rotatedX + cx
            y = rotatedY + cy
            r_xys += [x, y]
        self.car.vertices = r_xys


if __name__ == '__main__':
    np.random.seed(1)
    env = CarEnv()
    for ep in range(20):
        s = env.reset()
        # for t in range(100):
        while True:
            env.render()
            s, r, done = env.step(env.sample_action())
            if done:
                break
