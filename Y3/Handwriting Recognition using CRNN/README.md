# Handwriting Recognition using CRNN

Created a handwriting recognition using CNN and Bidirectional RNN model together and trained the model in a CTC (connectionist temporal classification) loss and 2 regular CNN models with 3 and 5 layers for comparison on which is more accurate.

### Contribution to this project:
- Abidon Jude Fernandes

## Coursework Project Tasks
Choose an topic to which machine learning can make a significant contribution. After the decision of a topic, each student are expected to 
- Survey the background of the topic.
- Define a problem to solve. 
- Collect or create a dataset. 
- Select an appropriate machine learning model. 
- Implement and apply the model and baselines (at least two) to the dataset. 
- Compare and evaluates the models under an appropriate criterion. 
- Discuss the results. 


**Accomplishment:**
1. Loaded the train and valid datasets and used the matplotlib library to apply the necessary parameters to view the handwriting images.
2. Cleaned the datasets of unreadable images, converted all lowercase labels to uppercase and reset the index.
3. Established a preprocessing stage where all the images are loaded as grayscale images, reshaped to 256Wx64H, padded small images with white pixels, image is rotated clockwise to become (x, y) shape and is normalised to range [0, 1]. Split the datasets to train and test images sets.
4. Applied a CTC Loss to provide alignment between sequences where it is difficult for the RNN layer. The labels are converted to integers to represent each character (A-Z, -, ’, and space) and are set at the maximum length of 64 for prediction and accepts 24 for inputs.
5. Developed a CRNN model consists of 3 CNN layers, reshaped the CNN layer to incorporate Bidirectional LSTM layer, and applied the CTC loss function and trained the model on 60 epochs.
6. Established a validation class to see how many characters and words were predicted correct in percentage first then for each handwriting images, a validation loss and training loss graph and test, classification report and a confusion matrix was created to see if the model learning or just copying the answers.
7. Conclusion, the CRNN model with CTC loss outperformed in terms of accuracy by a huge margin against the 3 and 5 CNN layers models due to its complexity.

## Findings
By observing these results and comparing side by side the CRNN hybrid model to the two baselines models which are the 3 CNN and 5 CNN layers models. The conclusion is that the CRNN fared better when it came to overall words and characters prediction of the alphabets and numbers over the two baselines models. The CRNN has a high accuracy rate when it comes to predicting handwriting images that is difficult to read whereas the two CNN cannot do it accurately enough to get a pass. The downside of using CRNN model is the speed of the model being trained at 2 minutes per epochs whereas the CNN models trained at 7s per epochs but suffers overfitting and has a memorisation issue.

In conclusion, the CRNN hybrid model was a success, and this research provides an excellent in-depth analysis about the styles of writings and how a hybrid model and a loss function can improve the prediction and learning rate of a model. This showed that a hybrid model can used in many settings and can enhance the prediction rate of any given data set.

## Software
**Utilised Python programming language in Anaconda Distribution Navigator, Jupyter Notebook IDE, and TensorFlow, cv2, NumPy, Pandas, Keras, Matplotlib, imutils libraries in this project.**
