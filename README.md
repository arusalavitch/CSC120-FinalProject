# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?

    The project was tackled by initially making a basic game plan, and listing out possible ideas, or layouts of the game map. Then files were made for each part of the game, like for each room, puzzle, commands for gerbil, etc. The final part was putting it all together and having each file implement other parts of our main file.  

 - What **new thing(s)** did you learn / figure out in completing this project?

    We learned a lot about how to work in groups to complete a project and how to allocate different classes to different people. Also the merge feature on github was harder to work with that we had originally thought that it would be.

 - Is there anything that you wish you had **implemented differently**?

    I wish that we had worked with seperate classes from the beginning. (see the part about piece of feedback)


 - If you had **unlimited time**, what additional features would you implement?

    If we had unlimited time, we could possibly expand the map even more and add additional puzzles for the gerbil to play. Also, we could implement a health feature where the gerbil has to act smartly and preserve its health, including finding food, water, etc. 

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?

    One of our friends who is also in AEMES suggested that instead of listing all of the rooms in the Controller class, we divide them into different classes and then just call them from the main in Controller. It helped us to identify issues that were specific to each room instead of just getting to an exception and having to solve that very slowly.


 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?

    If we could go back in time, we would likely break down the development tasks into even smaller, more manageable chunks, or perhaps allocate more time for testing and debugging. Additionally, we would prioritize features based on their importance to the overall gameplay experience. For instance, we spent a lot of time on designing the storyline and making sure it all had a good plot, but it didn't run as smoothly as we would like and there seemed to be issues with the scanners that we should have figured out earlier.

 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

    It was definitely harder to work with a team than it would have been to work individually, just because of how we each thought we wanted the other to implement things vs how we actually wanted them implemented. Some of the names that we gave to things didn't line up and we ended up going back and redoing things that would have been simpler if we had communicated better. 

Design Justification:

We chose our design to mimic an escape the room but based on a gerbil that lives in a dorm room. Our design intiially included a health program where the gerbil had to make smart choices and find food and water in order to keep its health up but we decided this was going to be a bit too complicated with the time we had and we decdied just to focus on getting the puzzles and commands working. Additionally, we were thinking of adding more human interactions and barriers for the gerbil but after running through the game multiple times we realized that having the puzzles was a good enough implementation to keep the player entertained and also keep the code running. Implementing more human interactions would have been not very useful since we would also have to implement a health factor for the gerbil. 
