# Using a Recurrent Neural Network Architectures with Support Vector Machine to Detect False Information

Created two AI programs to detect true and false information in news articles and text messages on social media applications using four recurrent neural networks (LSTM, GRU, Bidirectional LSTM, and Bidirectional GRU) with support vector machine (SVM).

### Owner of this Project:
- Abidon Jude Fernandes

## Product Stages
Created Using 4 RNN-SVM models for Fake News Detection and Using 4 RNN-SVM models for Sentiment Analysis.

Fake News Detection Software Product Project Link: https://www.kaggle.com/code/abidonjfernandes/using-a-rnn-svm-models-for-fake-news-detection

Sentiment Analysis Software Product Project Link: https://www.kaggle.com/code/abidonjfernandes/using-a-rnn-svm-models-for-sentiment-analysis

The two products cycle through 9 stages to detect false information. These stages are Load the Data Set, Text Preprocessing, Splitting the Data Set, Tokenisation, Label Encoding, Pretrained GloVe word embedding, Training the four hybrid models, Accuracy Analysis and Testing Class.

**Accomplishment:**
1. Imported two separate datasets from Kaggle and used wordcloud and matplotlib library to analysis the information in the dataset. Used this information to eliminate skewed dataset results and reduced its capacity so it is equal.
2. Implemented the NLTK library in the text preprocessing stage to remove URL, HTML, integers, emojis, punctuations, unnecessary texts, stopwords and stemmed the words down using Porter version of Stemming so it is simple for the model to understand.
3. Split the dataset to 80% training and 20% testing for efficiency. Implemented the keras library to apply hyper parameters and tokenise the dataset, then hot encoded the labels so it can be processed safely in the pretrained GloVe word embedding layer.
4. Incorporated a Pretrained GloVe word embedding layer into all the hybrid models to improve the model’s ability to differentiate between negative and positive words, and cluster similar words together into their respective categories.
5. Developed 4 RNN-SVM models with 2 RNN layers of 258 nodes, 3 dropout layers, 2 dense layers, 1 SVM layer equipped with Hinge losses, kernel regulariser and relu activation, and 1 linear activation and Adam optimiser. Trained the model on a GPU on 10 epochs and a batch size of 256 to detect true and false information.
6. Analysed the accuracy, complexity, and performance of the 4 models to see if it is learning from its mistake or just copying the answers. The hybrid models were tested by a validation and non-validation accuracy and loss graphs and test, test dataset, classification report, confusion matrix, and a testing class full of real-life news articles and Twitter text messages.
7. Conclusion, the LSTM-SVM model is best suited for fake news detection in news articles with its internal 3 gate system, whereas the Bidirectional GRU-SVM model is best suited for sentiment analysis in text messages on social media applications with its internal 2 gate system.

## Conclusion
**Using a RNN-SVM models for Fake News Detection conclusion:**
The LSTM-SVM model is the best model to use when trying to detect true or false news articles. This hybrid model has an accuracy rate of 87% compared to the rest of the RNN-SVM hybrid models. This model was able to understand fake news articles and true news articles compared to other models which failed to distinguish between two true and two fake news articles. This model has the benefit of using its three gates to its maximum potential and being a powerful feed-forward neural network. These gates are the input gate which inputs the information, forget gate which discards any biased or low result values, and the output gate which outputs the result combined with the SVM optimal hyperplanes which are designed for the separation of training data without errors and soft margins which allows for an analytic treatment of learning with errors on the training set compared to the Bidirectional models which are complex since it came to goes forward and backward with more training time. In the end, the complexity of this model allows it to differentiate between what news articles are real or fabricated. <br />

**Using a RNN-SVM models for Sentiment Analysis conclusion:**
The Bidirectional GRU-SVM model is the best model to use to detect human emotions in Twitter tweets text messages. This hybrid model has an accuracy rate of 69% compared to the rest of the RNN-SVM hybrid models. This model can understand positive, negative, neutral, and sarcastic sentences but fails to understand a scary joke sentence compared to the Bidirectional LSTM-SVM model which is able to detect only neutral and the negative sentences. This is possible because the Bidirectional GRU-SVM model has a GRU model has 2 gates which are the update and reset gate compared to the Bidirectional LSTM-SVM model which has a LSTM model and it has 3 gates and they are the input, forget and output gates. Being a bidirectional model, it goes backwards and forwards inside the neural network before finishing its tasks. This allows the model to learn and correct its mistakes at a 2x rate compared to the non-bidirectional models. This simplicity is the GRU main benefit combined with the SVM optimal hyperplanes which is designed for the separation of training data without errors and soft margins which allows for an analytic treatment of learning with errors on the training set compared to the LSTM model which has complex with 3 gates.


## Software
**Utilised Python programming language in Anaconda Distribution Navigator, Jupyter Notebook IDE, and TensorFlow, Keras, Scikit-learn, NLTK, NumPy, Pandas, Matplotlib, Wordcloud libraries in this project.**
