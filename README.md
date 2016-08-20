# Artificial Intelligence
This was a small project i did for artificial inteligence while studying in Poland.

![](http://cdn.pcwallart.com/images/chess-pieces-queen-wallpaper-3.jpg)

# Information about the project

The projects challange was to find all solutions for placing N queens in an N x N chess board, in a way that no queen hits another queen. There are two approaches for this problem in the solution, one with simple recursive backtracking and one of backtracking with a simple forward checking to improve the computation time.

# Defining The Variables/Constraints/Domains

__The Variables__ in this case can be for example V1,V2..Vn, this variables can represent each column of the board, which can only contain one queen.

__The Domain__ can be Dv1,Dv2,Dv3…Dvn which represent the finite possible values of the variables, in this case its “-“ for an empty spot, “Q” for a queen and in the case of forward checking “0,1…n” for the spots removed by the Q0,Q1…Qn constraint.

__The Constraints__ in this problem the constraints are, the queens cannot be in the same Row, Column or Diagonal.

# Testing Different params

[![a.png](https://s3.postimg.org/6gyyu2tr7/image.png)](https://postimg.org/image/uxh4ojuhr/)

__Graph showing the computation time for backtracking with N queens.__

[![b.png](https://s4.postimg.org/bn8bt4ogt/image.png)](https://postimg.org/image/hbemk0st5/)

__Graph showing the computation time with Forward Checking with N queens.__

In both cases, the more the Queens that have to be placed, the longer the algorithm will take to solve the problem. This starts to be noticeable after 10 queens where the amount of time starts to increase in a more “visual” way. The computation time without forward checking is faster with low number of queens, but with a low number of queens, the computation time is almost irrelevant.

[![c.png](https://s3.postimg.org/mzn8gk1yb/image.png)](https://postimg.org/image/yor84iswv/)

__Difference between backtracking and forward checking on time.__

On this graph we can see that after the 10’th queen the forward checking starts to “payoff” its complexity and finding solutions in a much faster time, at 14 queens for example, the forward checking can find all solutions for it in about half the time, a simple backtracking takes.

# Interesting Results

[![d.png](https://s4.postimg.org/5zalayq59/image.png)](https://postimg.org/image/3uq89voih/)

__Output example of the forward Checking algorithm.__

It was interesting to notice how something like forward checking can improve the computation time, which was unexpected until I understood how it actually works, and seeing how much something that looks like its going to increase computation time due to its complexity, actually decreasing it on some harder computation cases (like over 10 queens, when it starts to payoff using forward checking.) I think an interesting result is that at 14 queens the computation time with forward checking is actually reduced to half.
