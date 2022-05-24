package coursework;

import java.io.IOException;
import java.util.ArrayList;

public class AllNotes extends CommonCode {

    private ArrayList<Note> allNotes = new ArrayList<>();
    private String crse = "";
    private int maxID = 0;

    AllNotes() {
        readAllNotes();
    }

    public final int getMaxID() {
        maxID++;
        return maxID;
    }

    protected void readAllNotes() {
        ArrayList<String> readNotes = new ArrayList<>();

        readNotes = readTextFile(appDir + fileSeparator + "Note" + fileSeparator + "Notes.txt");
        System.out.println(readNotes.get(0));

        if (!"File not found".equals(readNotes.get(0))) {
            allNotes.clear();
            for (String str : readNotes) {
                String[] tmp = str.split("\t");

                int nid = Integer.parseInt(tmp[0]);
                Note n = new Note(nid, tmp[1], tmp[2], tmp[3]);
                allNotes.add(n);

                if (nid > maxID) {
                    maxID = nid;
                }
            }
        }
        maxID++;
    }

    public void addNote(int maxID, String course, String note) {
        Note myNote = new Note(maxID, course, note);
        allNotes.add(myNote);
        writeAllNotes();
    }

    public ArrayList<Note> getAllNotes() {
        return allNotes;
    }

    private void writeAllNotes() {
        String path = appDir + fileSeparator + "Note" + fileSeparator + "Notes.txt";
        ArrayList<String> writeNote = new ArrayList<>();

        for (Note n : allNotes) {
            String tmp = n.getNoteID() + "\t";
            tmp += n.getCourse() + "\t";
            tmp += n.getDayte() + "\t";
            tmp += n.getNote();
            writeNote.add(tmp);
        }
        try {
            writeTextFile(path, writeNote);
        } catch (IOException ex) {
            System.out.println("Problem! " + path);
        }
    }

    public String searchAllNotesByKeyword(String noteList, int i, String s) {
        if (i == allNotes.size()) {
            return noteList;
        }

        if (allNotes.get(i).getNote().contains(s)) {
            noteList += allNotes.get(i).getNote() + "\n";
        }

        return searchAllNotesByKeyword(noteList, i + 1, s);
    }
}
