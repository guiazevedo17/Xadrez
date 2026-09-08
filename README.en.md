<h1 align="center">Chess Game</h1>

<p align="center"><em>ChessQMate — a two-player chess game in Java, with JavaFX/FXML screens and a board drawn in Swing.</em></p>

<p align="center">
  <img alt="Java" src="https://img.shields.io/badge/Java-17%2B-007396?logo=openjdk&logoColor=white">
  <img alt="JavaFX" src="https://img.shields.io/badge/JavaFX-FXML-1f6feb">
  <img alt="Swing" src="https://img.shields.io/badge/Swing-AWT-5c4033">
  <img alt="Release" src="https://img.shields.io/badge/release-0.6-orange">
  <img alt="Context" src="https://img.shields.io/badge/academic-project-6f42c1">
</p>

<p align="center"><a href="README.md">Português</a> · <b>English</b></p>

---

## 📸 Preview

<p align="center">
  <img alt="ChessQMate main menu" src="docs/screenshots/01-menu.png" width="320">
</p>

<p align="center"><sub>Main menu: player registration and starting a match.</sub></p>

<p align="center">
  <img alt="Player registration screen" src="docs/screenshots/02-cadastro-jogadores.png" width="420">
</p>

<p align="center"><sub>Registration of the two players.</sub></p>

<p align="center">
  <img alt="Board in the starting position" src="docs/screenshots/03-tabuleiro-inicial.png" width="620">
</p>

<p align="center"><sub>The board in the starting position, with the turn indicator and the side panel.</sub></p>

<p align="center">
  <img alt="Match in progress" src="docs/screenshots/04-partida-em-andamento.png" width="620">
</p>

<p align="center"><sub>A match in progress after a few developing moves; the turn has already passed to Black.</sub></p>

<p align="center">
  <img alt="Incomplete registration warning" src="docs/screenshots/05-cadastro-nao-concluido.png" width="420">
</p>

<p align="center"><sub>Warning shown when starting a match without both players registered.</sub></p>

---

## 📌 Context and Motivation

This was the **final project for the Programming Paradigms B course**, taken at PUC-Campinas during the second semester of 2021. The assignment was to build a complete desktop application in Java, putting into practice the object-oriented concepts covered in class: inheritance, abstract classes, polymorphism, encapsulation, and the separation between model and interface.

I chose chess because it forces you to model a real domain. Each type of piece behaves differently, yet all of them share common state and responsibilities — exactly the scenario where a class hierarchy with an abstract validation method makes sense. It was also my first serious contact with Java and with building graphical interfaces.

---

## 🧰 Technology Stack

| Technology | Version | Role in the project |
| --- | --- | --- |
| Java (JDK) | 17 at the time; validated here with **Temurin 23.0.2** | Language and runtime for the whole application |
| JavaFX | 17.0.1 at the time; validated here with **OpenJFX 21.0.5** | Menu, registration and warning screens, declared in FXML |
| FXML | — | Declarative markup for the three screens, bound to controllers via `fx:controller` |
| Swing / AWT | Part of the JDK | Board window: `JFrame`, `JPanel` with `GridLayout(8,8)` and `JLabel` for the pieces |
| Visual Studio Code | — | IDE used during development (`.vscode/launch.json` and `settings.json` are versioned) |

The project uses **two graphics libraries at the same time**, and that is intentional in the code: the flow screens (menu, registration, warning) are JavaFX loaded from `.fxml` files, while the board is assembled programmatically in Swing, without FXML. There is no Maven, no Gradle and no external dependencies — compilation is done directly with `javac`.

---

## ⚙️ Environment Setup

Since JavaFX stopped shipping with the JDK as of Java 11, it has to be downloaded separately.

1. **JDK 17 or newer.** The most recent validation of this README was done with Temurin 23.0.2:

   ```bash
   java -version
   # openjdk version "23.0.2" 2025-01-21
   ```

2. **OpenJFX SDK.** Download the SDK for your platform from [gluonhq.com/products/javafx](https://gluonhq.com/products/javafx), unzip it and point a variable at the folder:

   ```bash
   export JAVAFX_HOME=/path/to/javafx-sdk-21.0.5
   ```

The required modules are `javafx.controls` and `javafx.fxml`; the others (`javafx.base`, `javafx.graphics`) come in transitively.

---

## ▶️ Running the Project

All commands must be run **from the repository root**. This is not a detail: the piece images and the window icon are loaded through relative filesystem paths (`src/images/...`), so the working directory has to be the project root or the pieces will not show up on the board.

**1. Compile**

```bash
javac -encoding UTF-8 -d bin \
  --module-path "$JAVAFX_HOME/lib" \
  --add-modules javafx.controls,javafx.fxml \
  $(find src -name '*.java')
```

**2. Copy the resources onto the classpath**

The `.fxml` files are loaded by the classloader, and the images referenced inside them are resolved relative to the `.fxml` itself, so both need to sit next to the compiled classes:

```bash
cp -R src/fxmls src/images bin/
```

**3. Run**

```bash
java -cp bin \
  --module-path "$JAVAFX_HOME/lib" \
  --add-modules javafx.controls,javafx.fxml \
  classes.Menu
```

It is also possible to open the board directly, bypassing the menu — handy during development, although the player names come up blank:

```bash
java -cp bin \
  --module-path "$JAVAFX_HOME/lib" \
  --add-modules javafx.controls,javafx.fxml \
  classes.vision.JChess
```

And there is a standalone piece-sprite animation, written as a JavaFX experiment and not wired into the game:

```bash
java -cp bin \
  --module-path "$JAVAFX_HOME/lib" \
  --add-modules javafx.controls,javafx.fxml \
  classes.Animation
```

---

## 🎮 How to Play

The program starts on a **Menu** screen with two buttons: one for registering the players and another for starting the match.

1. **Cadastrar Jogadores** (Register Players) opens the registration screen, with one field per player. The *Cadastrar* button stores the names and takes the user back to the menu.
2. **Iniciar Partida** (Start Match) is only allowed once **both** players are registered. If either name is empty, the program shows the warning screen "Jogador(es) não cadastrado(s)!" ("Player(s) not registered!") and returns to the menu.
3. With both players registered, the **board screen** opens and shows each player's pieces. To play, simply **select the piece** you want to move and then **click the square you want to move it to** — the game will perform the move if it is possible. Clicking the selected piece again cancels the selection.

Player 1 controls White and starts the match. The label at the top of the window shows whose turn it is, by the registered name, and switches after every valid move. The side panel holds the *Propor Empate* (Offer Draw) and *Desistir* (Resign) buttons.

---

## 🏛️ Domain Model

The code deliberately separates **game rules** from **presentation**, and that separation is reflected in the packages.

```
classes.pieces   → the model: what a piece is and how it moves
classes          → match state (Board) and the JavaFX entry point (Menu)
classes.vision   → the Swing visual layer of the board (J* prefix)
controllers      → the JavaFX controllers for the FXML screens
```

### Piece hierarchy

`Piece` is an **abstract class** holding everything any piece has — colour (`ColorEnum.WHITE` / `BLACK`), row, column, image path, a reference to the board, and the `captured`, `selected`, `possible` and `capturable` flags. It declares a single abstract method:

```java
public abstract boolean checkMovement(int destinyLine, int destinyColumn);
```

```
                            Piece (abstract)
                                  │
      ┌──────────┬──────────┬─────┴─────┬──────────┬──────────┐
    Pawn       Rook       Knight      Bishop     Queen       King
```

Each subclass implements `checkMovement` in its own way, and `Board` always calls the superclass method — pure polymorphism, with no per-type `if`. This is the backbone of the object-oriented exercise the course asked for.

### Vision layer

The `vision` layer mirrors the model in Swing components: `JChess` (`JFrame`) assembles the window, `JBoard` (`JPanel` with `GridLayout(8,8)`) draws the 64 squares, `JSquare` (`JPanel`) represents a square and stores its row/column, and `JPiece` (`JLabel`) carries the piece icon. The board is **drawn in code**, not described in FXML.

The interaction cycle is straightforward: `JBoard` listens for clicks, translates the clicked square into coordinates and calls `Board.performPlay(row, column)`; the model decides whether that is a selection, a cancellation or a move; then `JBoard.drawBoard()` rebuilds the grid from the model's new state.

---

## 📁 Folder Structure

```
Xadrez/
├── src/                     the project itself, where changes are made
│   ├── classes/             the project classes
│   │   ├── Menu.java        JavaFX Application — entry point
│   │   ├── Board.java       match state: 8x8 matrix, selection and turn
│   │   ├── Animation.java   JavaFX sprite animation (separate experiment)
│   │   ├── pieces/          the model: Piece and its six subclasses + ColorEnum
│   │   └── vision/          Swing visual layer: JChess, JBoard, JSquare, JPiece
│   ├── controllers/         the controllers behind the FXML screens
│   ├── fxmls/               all the .FXML screens
│   └── images/              all the images used throughout the project
│       ├── pieces/whites/   white pieces
│       ├── pieces/blacks/   black pieces
│       ├── buttons/         menu button icons
│       ├── animation/       animation frames
│       └── messages/        warning screen icon
├── bin/                     compilation output (copy of classes and resources)
├── docs/screenshots/        screenshots used in this README
└── .vscode/                 run configurations used during development
```

---

## 🚧 Project Status

This project sits at **release 0.6** because a few points were still missing before it could reach its first 1.0 version. To make it clear what the code actually does, here is what is implemented and what is not — all of it verified directly in the source.

**Working today**

- The complete screen flow: menu, registration, registration validation and opening the board.
- A 64-square board built with all 32 pieces in the correct starting position.
- Selecting and deselecting a piece, with a border highlight on the selected square.
- Turn alternation between White and Black, showing the name of the player to move at the top of the window.
- Moving with capture: moving onto a square occupied by an opposing piece replaces that piece on the board.
- Blocking a move onto a piece of the same colour.

**Not implemented yet**

- **Move validation for most pieces.** Only `Pawn` and `Rook` have rules of their own. `Knight`, `Bishop`, `Queen` and `King` implement `checkMovement` returning `true` unconditionally, meaning they accept any destination square.
- **The pawn's two-square advance.** The `firstMovement` field exists in `Pawn` and is updated after the first move, but `checkMovement` never reads it: the pawn only moves one square.
- **Clear-path checking for long-range pieces.** `Rook` only checks whether the destination is on the same row or column; there is no check for pieces in between, and the same applies to bishop and queen.
- **Castling, en passant and pawn promotion** — none of the three are in the code.
- **Check, checkmate and draw detection.** There is no verification of a king in check and no end-of-game condition; the match never ends on its own.
- **The *Propor Empate* and *Desistir* buttons.** They are in the interface and do get an `ActionListener`, but the listener bodies are empty.
- **Highlighting of legal squares and capturable pieces.** The `possible` and `capturable` flags exist in `Piece` and the green and red border drawing is written in `JSquare`, but commented out.
- **A captured-pieces list.** Captured pieces disappear from the board without being recorded anywhere.

There are also refactoring leftovers in the FXML files: some `ImageView` elements point at an `imagens/` folder that was renamed to `images/` and no longer exists, duplicating the ones that actually load. They do not break execution — JavaFX simply does not draw the missing image — but they remain as a record of the state in which the project was delivered.

---

## 👥 Credits

Developed by **Guilherme Gomes de Azevedo** — [@guiazevedo17](https://github.com/guiazevedo17).

Final project for the **Programming Paradigms B** course, PUC-Campinas, second semester of 2021.

### Closing Remarks

Even though, by the delivery date of **7 December 2021**, the project had not reached its final version fulfilling every requirement, the progress of the project itself and my personal growth were extremely significant: I gained an enormous amount of knowledge and, along with it, a stronger drive to look for new ways of solving the challenges put to us.

I would like to thank the **Pontifical Catholic University of Campinas** and professors **Leandro Alonso Xastre** and **Daniele Cristina Uchoa Maia Rodrigues**, who taught the course during the second semester of 2021 and gave us this experience of a first contact with the Java language and its object-oriented programming concepts.

---

## ⚖️ Rights

An academic project, developed for educational purposes and kept here as a record of learning. The code may be freely consulted and reused for study purposes. The icons and sprites in `src/images/` were gathered during the development of the assignment and belong to their respective authors.
