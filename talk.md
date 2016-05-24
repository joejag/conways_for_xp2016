# ACT 1: INTRO

 * TDA for me is about making code easier to change and read. Not fearful of it. 
 * The way TDA does thais is reducing coupling and improving cohesion of our code. Strongly coupled code goes together, try to make other things less coupled. TDA targets cohesion, coupled with Law of Demeter to reduce coupling.
 
 -> Right foot, making sure we understand what we mean by C&C.

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

-> That's TDA, but I want to also tell you about a sibling principle



# ACT 4: Law of Demeter

* Principle of least knowledge. Talk to your friends, not strangers.
* the LoD works as a check with TDA. Without it we can end up with long coupled chains of command and query calls.
* the LoD tells us to reduce class interaction to minimize coupling between classes
* Why: As each coupling happens we stop outselves from evolving our designs due to accidental coupling.
* So speak to as little as possible.

## Examples of LOD

* 1. Pizza -> Add addTopping to Pizza
* 2. UserDisplay -> Add to User. Mention small wrapper problem

-> Ok, so we are going to put behaviour where it belongs, and reduce our coupling. What else can we do to improve our designs?



# ACT 5: The anti-if campaign 

 * How many of you go out your way to avoid using if statements? It's a funny one, a campaing started called the anti-if campaign to get people to start using OO constructs instead. I've found some of the advice to be helpful for making  easier to understand code.
 * But what is wrong with ifs? 
 * 1. Makes it easier to modify code in bad ways. (show example) - biz logic ends up in the wrong place
 * 2. You must simulate execution in your head, and that takes energy away from you; energy you might spend on other, more important problems.
 * We cannot avoid ifs at system boundries when we validate incoming data. But we have great options in modern languages to create richer, better-documented and smaller solutions.

## Examples of anti-if

* Boolean Param -> Use two methods
* Switch on Type -> Use Polymorphism
* NullObject -> empty DataStructure. Offensive code
* NullObject -> empty data. don't have to use inheritance.
* Expressions and Statements -> collapse this to reduce mental hardship.
* NullChecking -> Defaults in case of null. 

* Mention: Predicates for filtering. We have richer, better-documented and smaller options to remove ifs. 
* Not all bad, but we don't have to always use the if. Conditionals Aren’t Evil, Unless You Duplicate Them

-> So how about we put all this theory into practice?



# ACT 6: Game of Life



# ACT 7: FINALE


