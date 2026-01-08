# Assignment 2: Freelance Job Portal (OOP)

Hi! This is my submission for Assignment 2.
I selected Topic #13: Freelance Job Portal. My goal was to create a system where an admin can manage freelancers and job listings using proper Object-Oriented principles.

## What I Implemented
I focused on meeting all the requirements from the assignment task. Here is a detailed breakdown of how I solved each part:

1. Data Abstraction & Inheritance
   To avoid code repetition, I created an abstract base class Person.
- Why: Since every user in the system has a name, it makes sense to keep this common logic in a parent class.
- Implementation: The Freelancer class extends Person. This demonstrates inheritance — I reuse the code from Person instead of writing it again.

2. Encapsulation
   I followed the principle of data protection.
- All fields (like name, price, skill) are private.
- I created public Getters and Setters to access or modify this data safely. This ensures that no one can break the internal state of the objects directly.

3. Polymorphism & Overriding
   I overrode standard Java methods to make the objects easier to work with:
- toString(): I customized this in all classes so that when I print a Freelancer or Job to the console, it shows readable text instead of a memory code.
- equals() & hashCode(): I implemented these in Freelancer and JobListing. This is important for comparing objects (e.g., checking if two job listings are identical).

4. Search and Sort Logic (The Portal Class)
   All the main logic happens in the Portal class. I used Java Streams to make the code clean and efficient:
- Filtering: The method findFreelancersBySkill() takes a string (e.g., "Java") and returns a list of only those freelancers who have that skill.
- Sorting: The method sortJobsByPrice() sorts the jobs from the lowest price to the highest using a Comparator.

## Project Files Description
Here is a quick guide to my code structure in the freelancee package:

- Main.java: The testing class. I create a Portal, add some dummy data (Freelancers and Jobs), and print the results of searching and sorting to prove it works.
- Person.java: The abstract parent class for all humans in the system.
- Freelancer.java: Represents a worker. It adds a specific skill field to the basic Person data.
- JobListing.java: Represents a task with a title and a price.
- Portal.java: The core manager. It holds the lists (ArrayList) of data and contains the business logic.

## How to Run
1. Open the project in IntelliJ IDEA.
2. Go to src/main/java/freelancee/Main.java.
3. Run the main() method.
4. Check the console output — you will see the sorted lists and search results.