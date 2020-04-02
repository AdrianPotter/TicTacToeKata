# TicTacToe Kata

# Requirements
- The game is played by two players
- After each move is placed, the player switches
- On each player's turn, the player specifies which tile of the board to place their move on
- The board is a composed of 9 tiles arranged in a 3 by 3 square
- The player may not place a move on a tile that has already had a move played on it
- The player may not place a move outside the boundaries of the board
- If there are no moves available, the game ends immediately in a draw and no further moves are played
- When a player wins, the game ends immediately and no further moves are played
- A player wins when they have placed three moves that form a horizontal, vertical, or diagonal line

# Clean code
The following is a list of coding principles that describe good practice in writing readable, maintainable code. The list is not exhaustive, but forms a broad guide.

- Is easy for other developers to understand
- Naming
    - Names should be meaningful and clearly indicate what a method does, or what a variable/class is
    - Can be pronounced easily, facilitating communication
    - Avoid acronyms
    - Avoid ambiguous names
    - Are consistent throughout the system
    - Are consistent with the domain and requirements
- Methods
    - Are easy to understand
    - The implementation conveys the intention of the method name and signature
    - Should be small. Opinion varies but try using a strict maximum of 20 lines, many suggest fewer
    - Do one thing
    - Should have no more than 2 arguments
    - Should not take Boolean parameters
    - Do not duplicate code
- Classes
    - Are easy to understand their scope
    - Have one responsibility; their scope is small
    - Should follow typical style: static variables first, then instance variables, then methods
    - Should be small. As with methods, opinion varies but try using a strict maximum of 500 lines. For this Kata, that should be easy
- Comments
    - Should be avoided; they cannot be tested and indicate the code is insufficiently descriptive
- Formatting
    - Is consistent
    - Lines no longer than 120 characters
    - Use default Java formatting assistance from IntelliJ on all files. This will mean it is consistent between developers
    - Source files should have no IntelliJ syntax warnings (occasionally they're unavoidable, but this should be feasible for the Kata)
- Design
    - Follow the Law of Demeter: objects can only operate on themselves, their parameters, objects they created or direct components of themselves. Don't make nested function calls: a.getB().getC().doThing()
    - Classes are well encapsulated: their interface does not expose internal implementation, all public methods are necessary and useful for achieving the goal of the class
    - Data classes do not contain business logic
- Error handling
    - Methods should not return `null`
    - Methods should not take `null` as inputs
    - Errors should typically be thrown as an exception to be handled by the caller, rather than hidden
    - Errors should provide sufficient information to allow the caller to make an informed decision about remedial action; avoid catch alls.
- Testing
    - Follow the same Clean Code principles as source code (naming, single responsibility etc.)
    - Unit tests should be fast
    - Unit tests should be independent
    - Unit tests should be repeatable in various environments
    - Unit tests should be meaningful; changing or removing any logic in either a test or source code should lead to a failing test
    - The target unit test coverage should be 100%. Missing coverage should be well understood
    
Adapted from: https://dzone.com/articles/clean-code-summary-and-key-points    
