# cotw-editor
Attempt to reverse engineer savegames of "Castle of the Winds" by Rick Saada

### Introduction
Castle of the Winds is a tile-based roguelike video game for Microsoft Windows, developed by SaadaSoft in 1989.

The game is composed of two parts: A Question of Vengeance, released as shareware, and Lifthransir's Bane, sold commercially. In 1998 the author of the game, Rick Saada, decided to distribute the entirety of Castle of the Winds free of charge.

Here are some screenshots:

![Inventory](http://www.myabandonware.com/media/screenshots/c/castle-of-the-winds-1ph/thumbs/castle-of-the-winds_3.png "Inventory")
![Outside](http://www.myabandonware.com/media/screenshots/c/castle-of-the-winds-1ph/thumbs/castle-of-the-winds_4.png "Outside")
![You died!](http://www.myabandonware.com/media/screenshots/c/castle-of-the-winds-1ph/thumbs/castle-of-the-winds_2.png "You died!")

More on [Wikipedia](https://en.wikipedia.org/wiki/Castle_of_the_Winds)

### The project
This is an attempt to reverse engineer the savegames of Castle of the Winds, both part 1 and 2.
At the moment it consists only of some binary patterns pinned in a Java "struct" (thanks to Javolution) and some functions for inspecting savegames and discover the meaning of the rest of savefile.

##### Javolution
The application uses Javolution.io.Struct to provide the equivalent of a C struct, allowing to map a savefile in a Java class with ease. I extended Struct class to add debug (hexdump) functionality.

##### How to run
Just type *make run*. You will need JDK and JRE (javac and java) version 7 or above.

