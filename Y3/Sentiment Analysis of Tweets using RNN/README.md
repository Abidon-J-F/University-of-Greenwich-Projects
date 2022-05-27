# TT

Created a RNN (LSTM, GRU, Bidirectional LSTM, and Bidirectional GRU) models to detect positive and negative text messages from Twitter as a group project.

### Contribution to this project:
- Abidon Jude Fernandes
- Ashley James Walker
- Sean Daly

## Coursework Project Tasks



**Accomplishment:**
1. Imported the Twitter airline sentiment dataset from Kaggle and implemented the NLTK library to clean the text of all emojis, punctuations and stopwords so the model can take in only critical information for analysis to detect if it is positive or negative tweets.
2. Split the dataset to 80% training and 20% testing for efficiency. Implemented the keras library to apply hyper parameters and tokenise the dataset, then hot encoded the labels so it can be processed safely in the pretrained GloVe word embedding layer.
3. Incorporated a Pretrained GloVe word embedding layer into all the hybrid models to improve the model’s ability to differentiate between negative and positive words in the airline sentiment Twitter tweets, and cluster similar words together into their respective categories.
4. Developed 4 RNN models with 2 RNN layers of 96 nodes, 2 dropout layers, 2 dense layers of relu and sigmoid activation, binary_crossentropy losses, and Adam optimiser. Trained the RNN models on the CPU on 10 epochs to detect positive and negatives tweets.
5. Analysed the accuracy, complexity, and performance of the 4 models to see if it is learning from its mistake or just copying the answers. The 4 models were tested by a validation and non-validation accuracy and loss graphs, and a testing class full of multiple emotion-based text messages.
6. Conclusion, the Bi-GRU model performed best in speed and simplicity with it having 2 internal gates over the Bi-LSTM with its 3 gates, but it is less accurate by 5-10% margin. The LSTM and GRU models underperformed due to the model being outdated.

## Findings
- Bi-directional performs better than the one directional implementations.
- Two layers is enough to create accurate models.
- GLOVE (just about) performed better than word2vec.
- GRU performs quicker, but drops accuracy. Does less training as it takes the number of times a word is used into account.
- LSTM performs better in the long run. Does more training as it doesn’t take in to account the number of times a word is used and just creates more training data.
- A recommendation for performing sentiment analysis on tweets would be to use GLOVE with a GRU network. Since tweets are limited to 280 characters, tweets are not going to be large so the stamina problem that GRU has is not too problematic.

## Software
**Utilised Python programming language, Google Colab IDE, and Pandas, NumPy, TensorFlow, Keras, Matplotlib, NLTK, Scikit-lean libraries in this project.**