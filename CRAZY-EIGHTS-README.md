# Crazy Eights Design Doc
## Instructions and Game Play

run `java PlayCrazyEights`  on the terminal.
The game will instruct you for output

* Crazy Eights Rules (taken from [Crazy Eights Wikipedia](https://en.wikipedia.org/wiki/Crazy_Eights)) :
Depending on the number of players**, each player gets an even amount of cards to begin.

The remaining cards of the deck are placed face down at the center of the table. The top card is then turned face up to start the game.
Players discard by matching rank or suit with the top card of the discard pile, starting with the player left of the dealer. They can also play any 8 at any time. If a player is unable to match the rank or suit of the top card of the discard pile and does not have an 8, they draw a card from the stockpile. When a player plays an 8, they must declare the suit that the next player is to play; that player must then follow the named suit or play another 8.
As an example: Once 6 ♣ is played the next player:
1. can play any of the other 6s
2. can play any of the clubs
3. can play any 8 (then must declare a suit)
4. can draw from the stockpile until willing and able to play one of the above
The game ends as soon as one player has emptied their hand. The first player to empty their hand is the winner.

** 7 cards for 2 players, 5 cards for 3 players, 4 cards for 4 players, 3 cards for 5 players, 2 cards for 7 players,

## Program Structure
To build this card game simulator, I broke the problem down into specific reusable objects that would typically be used when playing a card game. Ideally, for any game, we can reuse the Card, CardHand, and CardDeck classes. We need only to make a game object and a file that processes inputs.  I wanted to utilize object-oriented principles that allowed each class to hold the information that was needed for game-play.

## Language Choice
The reason I chose Java for this task is because of how readable it is object oriented projects like this one.
It is important that someone who is using this application can communicate their concerns and that it can be quickly and easily fixed, which emphasizes the importance of readability.
Java also has an easily implemented and usable library (Scanner) for parsing user input. 
