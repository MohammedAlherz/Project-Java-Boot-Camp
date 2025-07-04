# Tic Tac Toe Game

A console-based Tic Tac Toe game implemented in Java where you can play against the computer.

## Features

- **Single Player vs Computer**: Play against an AI opponent
- **Multiple Game Modes**: Choose to play 1 or 3 rounds
- **Time Limit**: 10-second time limit for each player move
- **Score Tracking**: Keeps track of wins across multiple rounds
- **Input Validation**: Robust error handling for invalid inputs
- **Replay Option**: Option to play multiple games in succession

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- A terminal or command prompt

### Steps
1. **Compile the program**:
   ```bash
   javac Main.java
   ```

2. **Run the program**:
   ```bash
   java Main
   ```

## How to Play

### Game Setup
1. When the game starts, you'll be welcomed with a title screen
2. Choose the number of rounds you want to play (1 or 3)
3. You are assigned 'X' and the computer is assigned 'O'

### Making Moves
1. The game board is numbered 1-9 as follows:
   ```
   | 1 | 2 | 3 |
   | 4 | 5 | 6 |
   | 7 | 8 | 9 |
   ```

2. On your turn, enter a number (1-9) corresponding to where you want to place your 'X'
3. You have 10 seconds to make each move - if you don't move in time, you forfeit your turn
4. The computer will automatically make its move after you

### Winning
- Get three of your symbols ('X') in a row horizontally, vertically, or diagonally
- If the board fills up without a winner, it's a draw
- In multi-round games, the player with the most round wins is the overall winner

### Game Controls
- **Position Selection**: Enter numbers 1-9 to place your mark
- **Play Again**: After a game ends, type "yes" to play another game or "no" to quit

## Game Rules

1. **Turn Order**: Player always goes first
2. **Valid Moves**: You can only place your mark in empty positions
3. **Time Limit**: Each player move has a 10-second time limit
4. **Win Condition**: Three symbols in a row (horizontal, vertical, or diagonal)
5. **Draw Condition**: Board is full with no winner

## Example Gameplay

```
======================================
      Welcome to Tic Tac Toe Game     
======================================
You are 'X' and the computer is 'O'

How many rounds do you want to play? (1 or 3): 1

===== Round 1 =====
-------------
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
-------------

Choose a position (1-9) [You have 10 seconds]: 5

-------------
| 1 | 2 | 3 |
| 4 | X | 6 |
| 7 | 8 | 9 |
-------------

Computer Turn:
-------------
| 1 | O | 3 |
| 4 | X | 6 |
| 7 | 8 | 9 |
-------------
```

## Error Handling

The game includes comprehensive error handling for:
- Invalid input types (non-numeric input)
- Out-of-range positions (not 1-9)
- Already occupied positions
- Time limit violations

## Technical Details

- **Language**: Java
- **Board Representation**: 3x3 character array
- **AI Strategy**: Random move selection
- **Input Handling**: Scanner with InputMismatchException handling
- **Time Management**: System.currentTimeMillis() for move timing

## Code Structure

- `Main.java`: Contains all game logic
- `initializeBoard()`: Sets up the game board with numbers 1-9
- `printBoard()`: Displays the current board state
- `playerMove()`: Handles player input and move validation
- `computerMove()`: Handles computer's random move selection
- `checkWinner()`: Checks for win conditions
- `isBoardFull()`: Checks if the board is full (draw condition)
- `playGame()`: Main game loop handling multiple rounds
