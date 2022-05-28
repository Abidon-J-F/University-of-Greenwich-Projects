# Using a Recurrent Neural Network Architectures with Support Vector Machine to Detect False Information

Created two AI programs to detect true and false information in news articles and text messages on social media applications using four recurrent neural networks (LSTM, GRU, Bidirectional LSTM, and Bidirectional GRU) with support vector machine (SVM).

### Owner of this Project:
- Abidon Jude Fernandes

## Product Stages
Created Using a RNN-SVM models for Fake News Detection and Using a RNN-SVM models for Sentiment Analysis.

Product Project Link: https://www.kaggle.com/abidonjfernandes/code

The two products cycles through 9 stages to detect false information. These stages are Load the Data Set, Text Preprocessing, Splitting the Data Set, Tokenisation, Label Encoding, Pretrained GloVe word embedding, Training the four hybrid models, Accuracy Analysis and Testing Class.

**Accomplishment:**
1. Imported two separate datasets from Kaggle and used wordcloud and matplotlib library to analysis the information in the dataset. Used this information to eliminate skewed dataset results and reduced its capacity so it is equal.
2. Implemented the NLTK library in the text preprocessing stage to remove URL, HTML, integers, emojis, punctuations, unnecessary texts, stopwords and stemmed the words down using Porter version of Stemming so it is simple for the model to understand.
3. Split the dataset to 80% training and 20% testing for efficiency. Implemented the keras library to apply hyper parameters and tokenise the dataset, then hot encoded the labels so it can be processed safely in the pretrained GloVe word embedding layer.
4. Incorporated a Pretrained GloVe word embedding layer into all the hybrid models to improve the model’s ability to differentiate between negative and positive words, and cluster similar words together into their respective categories.
5. Developed 4 RNN-SVM models with 2 RNN layers of 258 nodes, 3 dropout layers, 2 dense layers, 1 SVM layer equipped with Hinge losses, kernel regulariser and relu activation, and 1 linear activation and Adam optimiser. Trained the model on a GPU on 10 epochs and a batch size of 256 to detect true and false information.
6. Analysed the accuracy, complexity, and performance of the 4 models to see if it is learning from its mistake or just copying the answers. The hybrid models were tested by a validation and non-validation accuracy and loss graphs and test, test dataset, classification report, confusion matrix, and a testing class full of real-life news articles and Twitter text messages.
7. Conclusion, the LSTM-SVM model is best suited for fake news detection in news articles with its internal 3 gate system, whereas the GRU-SVM model is best suited for sentiment analysis in text messages on social media applications with its internal 2 gate system.

## Conclusion



## Software
**Utilised Python programming language in Anaconda Distribution Navigator, Jupyter Notebook IDE, and TensorFlow, Keras, Scikit-learn, NLTK, NumPy, Pandas, Matplotlib, Wordcloud libraries in this project.**
