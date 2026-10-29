# Mapping exercise: source to stored columns

This example's interface is the model/schema contract. The README starts with the two mappings, then gives case-sensitive module paths and commands that run from the correct directory. It distinguishes JPA/database checks from the original context smoke tests. A graphical interface, animation or font system would not clarify these contracts and is not added.

Constructor/read methods expose the mapped values while the original field-access annotations and SQL resources stay intact. A persistence-context clear makes the tests read the stored representation rather than the same in-memory object. Native SQL confirms the renamed columns and enforces the nullability boundary independently of repository validation. The product fixture exceeds 255 characters so the text mapping is actually exercised.

Original bootstrap data and packages remain in place; isolated contract slices disable that seed for deterministic assertions. README English/Spanish, small tables and concrete reading paths are the presentation surface. Results are local JDK 17/H2 checks and do not imply another database dialect or hosted service.
