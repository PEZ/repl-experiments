(ns example.some-data
  (:require [clojure.string :as string]))

(def some-text
  "Clojure is a dynamic, general-purpose programming language, combining the approachability and interactive development of a scripting language with an efficient and robust infrastructure for multithreaded programming. Clojure is a compiled language, yet remains completely dynamic – every feature supported by Clojure is supported at runtime. Clojure provides easy access to the Java frameworks, with optional type hints and type inference, to ensure that calls to Java can avoid reflection.

Clojure is a dialect of Lisp, and shares with Lisp the code-as-data philosophy and a powerful macro system. Clojure is predominantly a functional programming language, and features a rich set of immutable, persistent data structures. When mutable state is needed, Clojure offers a software transactional memory system and reactive Agent system that ensure clean, correct, multithreaded designs.

I hope you find Clojure's combination of facilities elegant, powerful, practical and fun to use.

Rich Hickey 
author of Clojure and CTO Cognitect
   
   Features

Clojure has a set of useful features that together form a simple, coherent, and powerful tool.

Dynamic Development

Clojure is a dynamic environment you can interact with. Almost all of the language constructs are reified, and thus can be examined and changed. You can grow your program, with data loaded, adding features, fixing bugs, testing, in an unbroken stream.

Functional Programming

Clojure provides the tools to avoid mutable state, provides functions as first-class objects, and emphasizes recursive iteration instead of side-effect based looping. Clojure is impure, yet stands behind the philosophy that programs that are more functional are more robust.

LISP

Clojure is a member of the Lisp family of languages. Many of the features of Lisp have made it into other languages, but Lisp's approach to code-as-data and its macro system still set it apart. Additionally, Clojure’s maps, sets, and vectors are as first class in Clojure as lists are in Lisp.

Runtime Polymorphism

Systems that utilize runtime polymorphism are easier to change and extend. Clojure offers simple, powerful and flexible mechanisms for runtime polymorphism. Clojure’s protocols and datatypes features add mechanisms for abstraction and data structure definition with no compromises vs the facilities of the host platform.

Concurrent Programming

Clojure simplifies multi-threaded programming in several ways. Because the core data structures are immutable, they can be shared readily between threads. Clojure, being a practical language, allows state to change but provides mechanism to ensure that, when it does so, it remains consistent, while alleviating developers from having to avoid conflicts manually using locks etc.

Hosted on the JVM

Clojure is designed to be a hosted language, sharing the JVM type system, GC, threads etc. All functions are compiled to JVM bytecode. Clojure is a great Java library consumer, offering the dot-target-member notation for calls to Java. Clojure supports the dynamic implementation of Java interfaces and classes.

Customers and stakeholders have substantial investments in, and are comfortable with the performance, security and stability of, industry-standard platforms like the JVM. While Java developers may envy the succinctness, flexibility and productivity of dynamic languages, they have concerns about running on customer-approved infrastructure, access to their existing code base and libraries, and performance. In addition, they face ongoing problems dealing with concurrency using native threads and locking. Clojure is an effort in pragmatic dynamic language design in this context. It endeavors to be a general-purpose language suitable in those areas where Java is suitable. It reflects the reality that, for the concurrent programming future, pervasive, unmoderated mutation simply has to go.

Clojure meets its goals by: embracing an industry-standard, open platform - the JVM; modernizing a venerable language - Lisp; fostering functional programming with immutable persistent data structures; and providing built-in concurrency support via software transactional memory and asynchronous agents. The result is robust, practical, and fast.

Clojure has a distinctive approach to state and identity.

Why Clojure?

Why did I write yet another programming language? Basically because I wanted:

A Lisp
for Functional Programming
symbiotic with an established Platform
designed for Concurrency
and couldn’t find one. Here’s an outline of some of the motivating ideas behind Clojure.

Lisp is a good thing

Often emulated/pillaged, still not duplicated
Lambda calculus yields an extremely small core
Almost no syntax
Core advantage still code-as-data and syntactic abstraction
What about the standard Lisps (Common Lisp and Scheme)?
Slow/no innovation post standardization
Core data structures mutable, not extensible
No concurrency in specs
Good implementations already exist for JVM (ABCL, Kawa, SISC et al)
Standard Lisps are their own platforms
Clojure is a Lisp not constrained by backwards compatibility
Extends the code-as-data paradigm to maps and vectors
Defaults to immutability
Core data structures are extensible abstractions
Embraces a platform (JVM)
Functional programming is a good thing

Immutable data + first-class functions
Could always be done in Lisp, by discipline/convention
But if a data structure can be mutated, dangerous to presume it won’t be
In traditional Lisp, only the list data structure is structurally recursive
Pure functional languages tend to strongly static types
Not for everyone, or every task
Clojure is a functional language with a dynamic emphasis
All data structures immutable & persistent, supporting recursion
Heterogeneous collections, return types
Dynamic polymorphism
Languages and Platforms

VMs, not OSes, are the platforms of the future, providing:
Type system
Dynamic enforcement and safety
Libraries
Abstract away OSes
Huge set of facilities
Built-in and 3rd-party
Memory and other resource management
GC is platform, not language, facility
Bytecode + JIT compilation
Abstracts away hardware
Language as platform vs. language + platform
Old way - each language defines its own runtime
GC, bytecode, type system, libraries etc
New way (JVM, .Net)
Common runtime independent of language
Language built for platform vs language ported-to platform
Many new languages still take 'Language as platform' approach
When ported, have platform-on-platform issues
Memory management, type-system, threading issues
Library duplication
If original language based on C, some extension libraries written in C don’t come over
Platforms are dictated by clients
'Must run on JVM' or .Net vs 'must run on Unix' or Windows
JVM has established track record and trust level
Now also open source
Interop with other code required
C linkage insufficient these days
Java/JVM is language + platform
Not the original story, but other languages for JVM always existed, now embraced by Sun
Java can be tedious, insufficiently expressive
Lack of first-class functions, no type inference, etc
Ability to call/consume Java is critical
Clojure is the language, JVM the platform
Object Orientation is overrated

Born of simulation, now used for everything, even when inappropriate
Encouraged by Java/C# in all situations, due to their lack of (idiomatic) support for anything else
Mutable stateful objects are the new spaghetti code
Hard to understand, test, reason about
Concurrency disaster
Inheritance is not the only way to do polymorphism
\"It is better to have 100 functions operate on one data structure than to have 10 functions operate on 10 data structures.\" - Alan J. Perlis
Clojure models its data structures as immutable objects represented by interfaces, and otherwise does not offer its own class system.
Many functions defined on few primary data structures (seq, map, vector, set).
Write Java in Java, consume and extend Java from Clojure.
Polymorphism is a good thing

Switch statements, structural matching etc yield brittle systems
Polymorphism yields extensible, flexible systems
Clojure multimethods decouple polymorphism from OO and types
Supports multiple taxonomies
Dispatches via static, dynamic or external properties, metadata, etc
Concurrency and the multi-core future

Immutability makes much of the problem go away
Share freely between threads
But changing state a reality for simulations and for in-program proxies to the outside world
Locking is too hard to get right over and over again
Clojure’s software transactional memory and agent systems do the hard part
In short, I think Clojure occupies a unique niche as a functional Lisp for the JVM with strong concurrency support. Check out some of the features or get started with Clojure.

First and foremost, Clojure is dynamic. That means that a Clojure program is not just something you compile and run, but something with which you can interact. Clojure is not a language abstraction, but an environment, where almost all of the language constructs are reified, and thus can be examined and changed. This leads to a substantially different experience from running a program, examining its results (or failures) and trying again. In particular, you can grow your program, with data loaded, adding features, fixing bugs, testing, in an unbroken stream.

The REPL

While Clojure can be embedded in a Java application, or used as a scripting language, the primary programming interface is the Read-Eval-Print-Loop (REPL). This is a simple console interface that allows you to enter and execute commands, and examine their results. You can start the Clojure REPL like this, and then follow along trying the samples in this feature tour:

Functional Programming

First-class functions
Immutable Data Structures
Extensible Abstractions
Recursive Looping
Clojure is a functional programming language. It provides the tools to avoid mutable state, provides functions as first-class objects, and emphasizes recursive iteration instead of side-effect based looping. Clojure is impure, in that it doesn’t force your program to be referentially transparent, and doesn’t strive for 'provable' programs. The philosophy behind Clojure is that most parts of most programs should be functional, and that programs that are more functional are more robust.

Clojure as a Dialect of Lisp

Clojure is a member of the Lisp family of languages. Many of the features of Lisp have made it into other languages, but Lisp’s approach to code-as-data and its macro system still set it apart. Clojure extends the code-as-data system beyond parenthesized lists (s-expressions) to vectors and maps. Thus vectors and maps can be used in macro syntax, have literal reader representations etc.

Lisp data, and thus Lisp code, is read by the reader. The result of reading is the data structure represented by the forms. Clojure can compile data structures that represent code, and as part of that process it looks for calls to macros. When it sees one, it calls the macro, passing the forms themselves as arguments, then uses the return value of the macro in place of the macro itself. Thus macros are functions that are called at compile time to perform transformations of code. Since code is data, all of the Clojure library is available to assist in the transformation. Thus macros allow Lisps, and Clojure, to support syntactic abstraction. You use macros for the same reasons you use functions - to eliminate repetition in your code. Macros should be reserved for situations for which functions are insufficient, e.g. when you need to control evaluation, generate identifiers etc. Many of the core constructs of Clojure are not built-in primitives but macros just like users can define. 

Runtime Polymorphism

Systems that utilize runtime polymorphism are easier to change and extend. Clojure supports polymorphism in several ways:

Most core infrastructure data structures in the Clojure runtime are defined by Java interfaces.
Clojure supports the generation of implementations of Java interfaces in Clojure using proxy (see JVM Hosted).
The Clojure language supports polymorphism along both class and custom hierarchies with multimethods.
The Clojure language also supports a faster form of polymorphism with protocols (but limited only to class polymorphism to take advantage of the JVMs existing capabilities for invocation).
Clojure multimethods are a simple yet powerful mechanism for runtime polymorphism that is free of the trappings of OO, types and inheritance. The basic idea behind runtime polymorphism is that a single function designator dispatches to multiple independently-defined function definitions based upon some value of the call. For traditional single-dispatch OO languages that value is the type of the 'receiver' or 'this'. CLOS generic functions extend dispatch value to a composite of the type or value of multiple arguments, and are thus multimethods. Clojure multimethods go further still to allow the dispatch value to be the result of an arbitrary function of the arguments. Clojure does not support implementation inheritance.

Multimethods are defined using defmulti, which takes the name of the multimethod and the dispatch function. Methods are independently defined using defmethod, passing the multimethod name, the dispatch value and the function body.

Concurrent Programming

Today’s systems have to deal with many simultaneous tasks and leverage the power of multi-core CPUs. Doing so with threads can be very difficult due to the complexities of synchronization. Clojure simplifies multi-threaded programming in several ways. Because the core data structures are immutable, they can be shared readily between threads. However, it is often necessary to have state change in a program. Clojure, being a practical language, allows state to change but provides mechanism to ensure that, when it does so, it remains consistent, while alleviating developers from having to avoid conflicts manually using locks etc. The software transactional memory system (STM), exposed through dosync, ref, ref-set, alter, et al, supports sharing changing state between threads in a synchronous and coordinated manner. The agent system supports sharing changing state between threads in an asynchronous and independent manner. The atoms system supports sharing changing state between threads in a synchronous and independent manner. The dynamic var system, exposed through def, binding, et al, supports isolating changing state within threads.

In all cases, Clojure does not replace the Java thread system, rather it works with it. Clojure functions are java.util.concurrent.Callable, therefore they work with the Executor framework etc.

Most of this is covered in more detail in the concurrency screencast.

Refs are mutable references to objects. They can be ref-set or altered to refer to different objects during transactions, which are delimited by dosync blocks. All ref modifications within a transaction happen or none do. Also, reads of refs within a transaction reflect a snapshot of the reference world at a particular point in time, i.e. each transaction is isolated from other transactions. If a conflict occurs between 2 transactions trying to modify the same reference, one of them will be retried. All of this occurs without explicit locking.

In this example a vector of Refs containing integers is created (refs), then a set of threads are set up (pool) to run a number of iterations of incrementing every Ref (tasks). This creates extreme contention, but yields the correct result. No locks!

Hosted on the JVM

Clojure is designed to be a hosted language, sharing the JVM type system, GC, threads etc. It compiles all functions to JVM bytecode. Clojure is a great Java library consumer, offering the dot-target-member notation for calls to Java. Class names can be referenced in full, or as non-qualified names after being imported. Clojure supports the dynamic implementation of Java interfaces and classes using reify and proxy:

Values and Change: Clojure’s approach to Identity and State

Imperative programming
Functional programming
Working Models and Identity
Object Oriented programming (OO)
Clojure programming
Concurrency
Message Passing and Actors
Summary
Many people come to Clojure from an imperative language and find themselves out of their element when faced with Clojure’s approach to doing things, while others are coming from a more functional background and assume that once they leave Clojure’s functional subset, they will be faced with the same story re: state as is found in Java. This essay intends to illuminate Clojure’s approach to the problems faced by imperative and functional programs in modeling the world.

Imperative programming

An imperative program manipulates its world (e.g. memory) directly. It is founded on a now-unsustainable single-threaded premise - that the world is stopped while you look at or change it. You say ”do this” and it happens, ”change that” and it changes. Imperative programming languages are oriented around saying do this/do that, and changing memory locations.

This was never a great idea, even before multithreading. Add concurrency and you have a real problem, because ”the world is stopped” premise is simply no longer true, and restoring that illusion is extremely difficult and error-prone. Multiple participants, each of which acts as though they were omnipotent, must somehow avoid destroying the presumptions and effects of the others. This requires mutexes and locks, to cordon off areas for each participant to manipulate, and a lot of overhead to propagate changes to shared memory so they are seen by other cores. It doesn’t work very well.

Functional programming

Functional programming takes a more mathematical view of the world, and sees programs as functions that take certain values and produce others. Functional programs eschew the external 'effects' of imperative programs, and thus become easier to understand, reason about, and test, since the activity of functions is completely local. To the extent a portion of a program is purely functional, concurrency is a non-issue, as there is simply no change to coordinate.

Working Models and Identity

While some programs are merely large functions, e.g. compilers or theorem provers, many others are not - they are more like working models, and as such need to support what I’ll refer to in this discussion as identity. By identity I mean a stable logical entity associated with a series of different values over time. Models need identity for the same reasons humans need identity - to represent the world. How could it work if identities like 'today' or 'America' had to represent a single constant value for all time? Note that by identities I don’t mean names (I call my mother Mom, but you wouldn’t).

So, for this discussion, an identity is an entity that has a state, which is its value at a point in time. And a value is something that doesn’t change. 42 doesn’t change. June 29th 2008 doesn’t change. Points don’t move, dates don’t change, no matter what some bad class libraries may cause you to believe. Even aggregates are values. The set of my favorite foods doesn’t change, i.e. if I prefer different foods in the future, that will be a different set.

Identities are mental tools we use to superimpose continuity on a world which is constantly, functionally, creating new values of itself.

Object Oriented programming (OO)

OO is, among other things, an attempt to provide tools for modeling identity and state in programs (as well as associating behavior with state, and hierarchical classification, both ignored here). OO typically unifies identity and state, i.e. an object (identity) is a pointer to the memory that contains the value of its state. There is no way to obtain the state independent of the identity other than copying it. There is no way to observe a stable state (even to copy it) without blocking others from changing it. There is no way to associate the identity’s state with a different value other than in-place memory mutation. In other words, typical OO has imperative programming baked into it! OO doesn’t have to be this way, but, usually, it is (Java/C++/Python/Ruby etc).

People accustomed to OO conceive of their programs as mutating the values of objects. They understand the true notion of a value, say, 42, as something that would never change, but usually don’t extend that notion of value to their object’s state. That is a failure of their programming language. These languages use the same constructs for modeling values as they do for identities, objects, and default to mutability, causing all but the most disciplined programmers to create many more identities than they should, creating identities out of things that should be values etc.

Clojure programming

There is another way, and that is to separate identity and state (once again, indirection saves the day in programming). We need to move away from a notion of state as ”the content of this memory block” to one of ”the value currently associated with this identity”. Thus an identity can be in different states at different times, but the state itself doesn’t change. That is, an identity is not a state, an identity has a state. Exactly one state at any point in time. And that state is a true value, i.e. it never changes. If an identity appears to change, it is because it becomes associated with different state values over time. This is the Clojure model.

In Clojure’s model, value calculation is purely functional. Values never change. New values are functions of old, not mutations. But logical identity is well supported, via atomic references to values (Refs and Agents). Changes to references are controlled/coordinated by the system - i.e. cooperation is not optional and not manual. The world moves forward due to the cooperative efforts of its participants and the programming language/system, Clojure, is in charge of world consistency management. The value of a reference (state of an identity) is always observable without coordination, and freely shareable between threads.

It is worth constructing programs this way even when there is only one participant (thread). Programs are easier to understand/test when functional value calculation is independent of identity/value association. And it’s easy to add other participants when they are (inevitably) needed.

Concurrency

Dealing with concurrency means giving up the illusion of omnipotence. A program must recognize there will be other participants, and the world will keep changing. So a program must understand that if it observes the values of the states of some identities, the best it can get is a snapshot, as they can subsequently acquire new states. But often that is good enough for decision making or reporting purposes. We humans do quite well with the snapshots provided by our sensory systems. The nice thing is any such state value won’t change in hand during the processing, as it is immutable.

On the other hand, changing state to a new value requires access to the 'current' value and the identity. Clojure’s Refs and Agents handle this automatically. In the case of Refs, any interaction you do must occur within a transaction (else Clojure will throw an exception), all such interaction will see a consistent view of the world as of a point in time, and no changes will proceed unless the states to be changed haven’t been changed by other participants in the meantime. Transactions support synchronous change to multiple Refs. Agents, OTOH, offer asynchronous change to a single reference. You pass a function and values, and, at some point in the future, that function will be passed the current state of the Agent and the return value of the function will become the Agent’s new state.

In all cases the program will see stable views of the values in the world, as those values can’t change, and sharing them among cores is fine. The trick is, ”values never change” means that making new values from old ones must be efficient, and it is in Clojure, due to its persistent data structures. They allow you to finally follow the oft-proffered advice to favor immutability. So you set the state of an identity to a new state by reading its current value, calling a pure function on that value to create a new value, and setting that value as the new state. These composite operations are made easy and atomic by the alter, commute and send functions.

Message Passing and Actors

There are other ways to model identity and state, one of the more popular of which is the message-passing actor model. In an actor model, state is encapsulated in an actor (identity) and can only be affected/seen via the passing of messages (values). In an asynchronous system, reading some aspect of an actor’s state requires sending a request message, waiting for a response, and the actor sending a response. It is important to understand that the actor model was designed to address the problems of distributed programs. And the problems of distributed programs are much harder - there are multiple worlds (address spaces), direct observation is not possible, interaction occurs over possibly unreliable channels, etc. The actor model supports transparent distribution. If you write all of your code this way, you are not bound to the actual location of the other actors, allowing a system to be spread over multiple processes/machines without changing the code.

I chose not to use the actor model for same-process state management in Clojure for several reasons:

It is a much more complex programming model, requiring 2-message conversations for the simplest data reads, and forcing the use of blocking message receives, which introduce the potential for deadlock. Programming for the failure modes of distribution means utilizing timeouts etc. It causes a bifurcation of the program protocols, some of which are represented by functions and others by the values of messages.
It doesn’t let you fully leverage the efficiencies of being in the same process. It is quite possible to efficiently directly share a large immutable data structure between threads, but the actor model forces intervening conversations and, potentially, copying. Reads and writes get serialized and block each other, etc.
It reduces your flexibility in modeling - this is a world in which everyone sits in a windowless room and communicates only by mail. Programs are decomposed as piles of blocking switch statements. You can only handle messages you anticipated receiving. Coordinating activities involving multiple actors is very difficult. You can’t observe anything without its cooperation/coordination - making ad-hoc reporting or analysis impossible, instead forcing every actor to participate in each protocol.
It is often the case that taking something that works well locally and transparently distributing it doesn’t work out - the conversation granularity is too chatty or the message payloads are too large or the failure modes change the optimal work partitioning, i.e. transparent distribution isn’t transparent and the code has to change anyway.
Clojure may eventually support the actor model for distributed programming, paying the price only when distribution is required, but I think it is quite cumbersome for same-process programming. YMMV of course.

Clojure is a functional language that explicitly supports programs as models and provides robust and easy-to-use facilities for managing identity and state in a single process in the face of concurrency.

In coming to Clojure from an OO language, you can use one of its persistent collections, e.g. maps, instead of objects. Use values as much as possible. And for those cases where your objects are truly modeling identities (far fewer cases than you might realize until you start thinking about it this way), you can use a Ref or Agent with e.g. a map as its state in order to model an identity with changing state. If you want to encapsulate or abstract away the details of your values, a good idea if they are non-trivial, write a set of functions for viewing and manipulating them. If you want polymorphism, use Clojure’s multimethods.

In the local case, since Clojure does not have mutable local variables, instead of building up values in a mutating loop, you can instead do it functionally with recur or reduce.

Why Clojure?

Clojure is a dynamic, general-purpose programming language supporting interactive development. Clojure is a functional programming language featuring a rich set of immutable, persistent data structures. As a dialect of Lisp, it has a code-as-data philosophy and a powerful macro system.
")

(def most-common-words-1000 ["the" "of" "to" "and" "a" "in" "is" "it" "you" "that" "he" "was" "for" "on" "are" "with" "as" "i" "his" "they" "be" "at" "one" "have" "this" "from" "or" "had" "by" "not" "word" "but" "what" "some" "we" "can" "out" "other" "were" "all" "there" "when" "up" "use" "your" "how" "said" "an" "each" "she" "which" "do" "their" "time" "if" "will" "way" "about" "many" "then" "them" "write" "would" "like" "so" "these" "her" "long" "make" "thing" "see" "him" "two" "has" "look" "more" "day" "could" "go" "come" "did" "number" "sound" "no" "most" "people" "my" "over" "know" "water" "than" "call" "first" "who" "may" "down" "side" "been" "now" "find" "any" "new" "work" "part" "take" "get" "place" "made" "live" "where" "after" "back" "little" "only" "round" "man" "year" "came" "show" "every" "good" "me" "give" "our" "under" "name" "very" "through" "just" "form" "sentence" "great" "think" "say" "help" "low" "line" "differ" "turn" "cause" "much" "mean" "before" "move" "right" "boy" "old" "too" "same" "tell" "does" "set" "three" "want" "air" "well" "also" "play" "small" "end" "put" "home" "read" "hand" "port" "large" "spell" "add" "even" "land" "here" "must" "big" "high" "such" "follow" "act" "why" "ask" "men" "change" "went" "light" "kind" "off" "need" "house" "picture" "try" "us" "again" "animal" "point" "mother" "world" "near" "build" "self" "earth" "father" "head" "stand" "own" "page" "should" "country" "found" "answer" "school" "grow" "study" "still" "learn" "plant" "cover" "food" "sun" "four" "between" "state" "keep" "eye" "never" "last" "let" "thought" "city" "tree" "cross" "farm" "hard" "start" "might" "story" "saw" "far" "sea" "draw" "left" "late" "run" "don" "t" "while" "press" "close" "night" "real" "life" "few" "north" "open" "seem" "together" "next" "white" "children" "begin" "got" "walk" "example" "ease" "paper" "group" "always" "music" "those" "both" "mark" "often" "letter" "until" "mile" "river" "car" "feet" "care" "second" "book" "carry" "took" "science" "eat" "room" "friend" "began" "idea" "fish" "mountain" "stop" "once" "base" "hear" "horse" "cut" "sure" "watch" "color" "face" "wood" "main" "enough" "plain" "girl" "usual" "young" "ready" "above" "ever" "red" "list" "though" "feel" "talk" "bird" "soon" "body" "dog" "family" "direct" "pose" "leave" "song" "measure" "door" "product" "black" "short" "numeral" "class" "wind" "question" "happen" "complete" "ship" "area" "half" "rock" "order" "fire" "south" "problem" "piece" "told" "knew" "pass" "since" "top" "whole" "king" "space" "heard" "best" "hour" "better" "true" "during" "hundred" "five" "remember" "step" "early" "hold" "west" "ground" "interest" "reach" "fast" "verb" "sing" "listen" "six" "table" "travel" "less" "morning" "ten" "simple" "several" "vowel" "toward" "war" "lay" "against" "pattern" "slow" "center" "love" "person" "money" "serve" "appear" "road" "map" "rain" "rule" "govern" "pull" "cold" "notice" "voice" "unit" "power" "town" "fine" "certain" "fly" "fall" "lead" "cry" "dark" "machine" "note" "wait" "plan" "figure" "star" "box" "noun" "field" "rest" "correct" "able" "pound" "done" "beauty" "drive" "stood" "contain" "front" "teach" "week" "final" "gave" "green" "oh" "quick" "develop" "ocean" "warm" "free" "minute" "strong" "special" "mind" "behind" "clear" "tail" "produce" "fact" "street" "inch" "multiply" "nothing" "course" "stay" "wheel" "full" "force" "blue" "object" "decide" "surface" "deep" "moon" "island" "foot" "system" "busy" "test" "record" "boat" "common" "gold" "possible" "plane" "stead" "dry" "wonder" "laugh" "thousand" "ago" "ran" "check" "game" "shape" "equate" "hot" "miss" "brought" "heat" "snow" "tire" "bring" "yes" "distant" "fill" "east" "paint" "language" "among" "grand" "ball" "yet" "wave" "drop" "heart" "am" "present" "heavy" "dance" "engine" "position" "arm" "wide" "sail" "material" "size" "vary" "settle" "speak" "weight" "general" "ice" "matter" "circle" "pair" "include" "divide" "syllable" "felt" "perhaps" "pick" "sudden" "count" "square" "reason" "length" "represent" "art" "subject" "region" "energy" "hunt" "probable" "bed" "brother" "egg" "ride" "cell" "believe" "fraction" "forest" "sit" "race" "window" "store" "summer" "train" "sleep" "prove" "lone" "leg" "exercise" "wall" "catch" "mount" "wish" "sky" "board" "joy" "winter" "sat" "written" "wild" "instrument" "kept" "glass" "grass" "cow" "job" "edge" "sign" "visit" "past" "soft" "fun" "bright" "gas" "weather" "month" "million" "bear" "finish" "happy" "hope" "flower" "clothe" "strange" "gone" "jump" "baby" "eight" "village" "meet" "root" "buy" "raise" "solve" "metal" "whether" "push" "seven" "paragraph" "third" "shall" "held" "hair" "describe" "cook" "floor" "either" "result" "burn" "hill" "safe" "cat" "century" "consider" "type" "law" "bit" "coast" "copy" "phrase" "silent" "tall" "sand" "soil" "roll" "temperature" "finger" "industry" "value" "fight" "lie" "beat" "excite" "natural" "view" "sense" "ear" "else" "quite" "broke" "case" "middle" "kill" "son" "lake" "moment" "scale" "loud" "spring" "observe" "child" "straight" "consonant" "nation" "dictionary" "milk" "speed" "method" "organ" "pay" "age" "section" "dress" "cloud" "surprise" "quiet" "stone" "tiny" "climb" "cool" "design" "poor" "lot" "experiment" "bottom" "key" "iron" "single" "stick" "flat" "twenty" "skin" "smile" "crease" "hole" "trade" "melody" "trip" "office" "receive" "row" "mouth" "exact" "symbol" "die" "least" "trouble" "shout" "except" "wrote" "seed" "tone" "join" "suggest" "clean" "break" "lady" "yard" "rise" "bad" "blow" "oil" "blood" "touch" "grew" "cent" "mix" "team" "wire" "cost" "lost" "brown" "wear" "garden" "equal" "sent" "choose" "fell" "fit" "flow" "fair" "bank" "collect" "save" "control" "decimal" "gentle" "woman" "captain" "practice" "separate" "difficult" "doctor" "please" "protect" "noon" "whose" "locate" "ring" "character" "insect" "caught" "period" "indicate" "radio" "spoke" "atom" "human" "history" "effect" "electric" "expect" "crop" "modern" "element" "hit" "student" "corner" "party" "supply" "bone" "rail" "imagine" "provide" "agree" "thus" "capital" "won" "t" "chair" "danger" "fruit" "rich" "thick" "soldier" "process" "operate" "guess" "necessary" "sharp" "wing" "create" "neighbor" "wash" "bat" "rather" "crowd" "corn" "compare" "poem" "string" "bell" "depend" "meat" "rub" "tube" "famous" "dollar" "stream" "fear" "sight" "thin" "triangle" "planet" "hurry" "chief" "colony" "clock" "mine" "tie" "enter" "major" "fresh" "search" "send" "yellow" "gun" "allow" "print" "dead" "spot" "desert" "suit" "current" "lift" "rose" "continue" "block" "chart" "hat" "sell" "success" "company" "subtract" "event" "particular" "deal" "swim" "term" "opposite" "wife" "shoe" "shoulder" "spread" "arrange" "camp" "invent" "cotton" "born" "determine" "quart" "nine" "truck" "noise" "level" "chance" "gather" "shop" "stretch" "throw" "shine" "property" "column" "molecule" "select" "wrong" "gray" "repeat" "require" "broad" "prepare" "salt" "nose" "plural" "anger" "claim" "continent" "oxygen" "sugar" "death" "pretty" "skill" "women" "season" "solution" "magnet" "silver" "thank" "branch" "match" "suffix" "especially" "fig" "afraid" "huge" "sister" "steel" "discuss" "forward" "similar" "guide" "experience" "score" "apple" "bought" "led" "pitch" "coat" "mass" "card" "band" "rope" "slip" "win" "dream" "evening" "condition" "feed" "tool" "total" "basic" "smell" "valley" "nor" "double" "seat" "arrive" "master" "track" "parent" "shore" "division" "sheet" "substance" "favor" "connect" "post" "spend" "chord" "fat" "glad" "original" "share" "station" "dad" "bread" "charge" "proper" "bar" "offer" "segment" "slave" "duck" "instant" "market" "degree" "populate" "chick" "dear" "enemy" "reply" "drink" "occur" "support" "speech" "nature" "range" "steam" "motion" "path" "liquid" "log" "meant" "quotient" "teeth" "shell" "neck"])

(def other-common-words ["etc" "vs" "its"])

(def common-words
  (set (concat most-common-words-1000 other-common-words)))

(comment
  (->> (string/split some-text #"\s+")
       (map string/lower-case)
       (remove common-words)
       (mapv
        #(clojure.string/replace % #"[,.]" ""))))