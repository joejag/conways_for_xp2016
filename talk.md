# ACT 1: INTRO

 * TDA for me is about making code easier to change and read. Not fearful of it. 
 * The way TDA does thais is reducing coupling and improving cohesion of our code. Strongly coupled code goes together, try to make other things less coupled. TDA targets cohesion, coupled with Law of Demeter to reduce coupling.
 * Right foot, making sure we understand what we mean by C&C.

## Cohesion

 * Cohesion is about how related a module is to itself. Interdepency within a module. This helps us understand its purpose.
 * Devs get coupling, but cohesion is harder to grasp as it's not an everyday word. The word comes from adhesive (duct tape, glue)
 * Cohesive means sticks to each other (clay, velcro). Answers the question: If i throw this code at that code, would it stick?
 * Ignoring Cohesion: Unrelated code that you forget to change, or behaviour burried in if statements which doesn't relate.

## Coupling

 * The degree one module depends on another, the interdepency between modules. This helps us change code.
 * If changing one module means changing another then coupling exists. We do want some coupling.
 * The worst thing we can do is put every bit of code in one giant method. Ruining it's cohesion. We want coupling, but we need to control it.
 * Ignoring Coupling leads to code that cause a ripple effect, and is hard to reuse without bringing other modules along with it.

-> But how do we measure coupling?



# ACT 2: Measuring Coupling with Connasence

 * Larry Constantine was responsible for giving us C&C. His measure of coupling was that the worst offendors were shared state and globals.
 * This is great advice. The main driver for OO was putting state next to the behaviour that changes it, then encapsulating it away from the rest of the world via message passing.
 * But a more fine grained measure exists. That is Connasence

## Connascene

 * Connascene like Cohesion is another word that makes more sense when you understand it's root. con (together) nasence (grow). It means two or more things must grow together. Beautiful description of the problem coupling poses.
 * Connascene gives us an order of different types of coupling, with the goal being to reduce the coupling via refactorings.
 * Localitlity is important when analysing connascene. Stronger forms are acceptable is the elements involved are closely related. That's where cohesion comes into play.
 * Targetting connascene means actively reducing the cost to change your system.

## Examples of Connasence

 * We'll go from weakest to highest. 
 * Name: agreeing on the name of something, most common type
 * Type: agreeing on the type of something
 * Meaning: when multiple components must agree on the meaning of specific values. (magic values)
 * Position: Must be adjacent or occur in a particular order (web service example for positional args)
 * Execution: two different lines of code have to be executed in a certain order for the program to be executed correctly.
 * Identity: Two components must reference the same object
 
-> Ok, now we have a common language, and identified the problem, let's talk about TDA!



# ACT 3: Tell Don't Ask 

* In the abstract I gave Alec Sharp's quote that Procedural code gathers info and makes decisions, OO code tells objects to do things.
* What it promotes is creating C&C code. This is achieved by making sure data & operations that depend on that data belong in the same object.
* In TDA it is a sin to query an object and change it's state on it's behalf. In these cases we want to think declaritvely rather than procedurally.
* A great example of this is when you get a raw object String back which has the colour "red". This isn't semantically an object as it has no association. It cannot answer questions, it's just data. Keep the data with behaviour that understands it.
* So in TDA with have commands and queries and we avoid giving out raw data. Let's see some examples.

## Examples of TDA

* 1. Admin user message -> push welcome into User class
* 2. System Monitor -> move check for overheating into the monitor
* 3. Stock Manager -> Move Stock count into StockManager
* 4. CoE -> use forEach, not hasNext(), next()



# ACT 4 Law of Demeter


ORIGINAL:

* Great, so exposed less state to acheive goals. Let's start sending queries and commands everywhere yeah? Not quite. Bad idea, why?
* Law of Demeter: Reduce class interaction to minimize coupling between classes.
* LoD Why? Reduce chance of breakage/change when a change happens. Reduce fragile brittle code.
* LoD implications: Say as little as possible, don't talk to more objects than you need to.
* LoD Says only talk to: itself, params passed in, objects it created, any composite objects.
* Lod says NOT: objects returned from a call (EXAMPLE: get list, inspect then add back to it -> Asking rather than telling)
* LoD example problems( coupled to: sortedlist, add method, query key) -> should be an add, then just call.
* LoD disadvantage: small wrapper methods.








# ACT 5: The anti-if campaign 

ORIGINAL:

* "The problem with control structures is that they often make it easy to modify code in bad ways.  Let's take a simple if-statement"
* WHY CARE: more branches makes code more complicated, for coupling it requires querying state
* "rich, better-documented, smaller and more powerful"
* "You must simulate execution in your head, and that takes energy away from you; energy you might spend on other, more important problems."
* Example: if statements and if expressions are two different beasts
* Avoidance Example (boolean param): Create two methods instead: File createFile(String name) File createTempFile(String name)
* Avoidance Example (switch->poly): Switch statements to Polymorphism
* Avoidance Example (null object): Offensive code -> Creates Defensive code. Empty list. If you are going to return nulls, use an Optional type.
* Avoidance Example (Default arguments): Ruby hash
* Example: Predicates for filtering
* Example: Better names (max instead if x > y)
* Ifs are important at boundries and necessary for some biz logic. But we can avoid a lot of them where it makes sense. We have to be careful not to introduce premature abstractions. But we have a lot of options for making richer, easier to read code.









# ACT 6: Game of Life



# ACt 7: FINALE


