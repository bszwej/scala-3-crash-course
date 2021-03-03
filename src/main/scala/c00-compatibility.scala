/** Compatibility
 * 
 * - Scala 2 source can be compiled with Scala 3 compiler.
 * - Scala 2.13.4 libraries work with Scala 3.
 * - Scala 3 libraries work with Scala 2.13.4.
 * 
 * Migration guide: https://scalacenter.github.io/scala-3-migration-guide/
 * Scala 3 community build: https://github.com/lampepfl/dotty/blob/master/community-build/test/scala/dotty/communitybuild/CommunityBuildTest.scala#L88
 * 
 * Breaking changes:
 * - Macros - completely new API
 * - Dropped constructs:
 *     - DelayedInit - https://dotty.epfl.ch/docs/reference/dropped-features/delayed-init.html
 *     - Existential types - https://dotty.epfl.ch/docs/reference/dropped-features/existential-types.html
 *     - Procedure syntax - def f() { ... }
 *     - Class shadowing - class Base { class Ops { ... } }; class Sub extends Base { class Ops { ... } }
 *     - XML literals - xml""" ... """
 *     - Symbol literals - 'literal
 *     - Auto application - def next(): T = ???; next
 *     - Compound types - val environment: Logging with UserRepo with Clock with Random = ???
 *     - Auto tupling - https://contributors.scala-lang.org/t/lets-drop-auto-tupling/1799
 *     - Early initializers - class C extends { ... } with SuperClass ...
 *     - See more: https://dotty.epfl.ch/docs/Dropped%20Features/index.html
 */
