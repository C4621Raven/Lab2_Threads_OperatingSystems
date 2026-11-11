# Concurrency and Synchronization Lab

## Purpose of the Assignment

I completed this lab for my Operating Systems course to simulate how multiple threads share data and how an operating system keeps them from interfering with each other. Instead of writing one large program, I built a series of eight small Java programs, each focused on a single concurrency problem and how to solve it.

The programs fall into four groups:

- **Race conditions**, where several threads repeatedly change a shared variable in different ways at the same time, showing how the value becomes corrupted when nothing controls access to it.
- **Synchronization**, where I fixed the race condition two ways: once with a `synchronized` method and once with semaphores, so that only one thread can change the variable at a time.
- **Deadlock**, where I deliberately caused every thread to freeze while waiting on another, once using semaphores and once using the `synchronized` keyword across two classes. I then wrote deadlock-free versions of both that still use multiple shared resources.
- **The producer-consumer problem**, where a producer adds data to a shared queue and a consumer removes it, using semaphores and a mutex to protect the queue. Each side does a random amount of "work" to behave like a real system.

Because automated tests are unreliable for multithreaded programs, I tested each program by running it repeatedly and checking that it produced the expected behavior, whether that was a corrupted value, a correct one, a deadlock, or a smooth run.
