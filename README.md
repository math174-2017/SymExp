# SymExp

SymExp is a kotlin library that will implment a symbolic algebra system, it is currently in early development and is unstable.

SymExp currently suports:

> * Polynomial Syntax
> * Evaluation for polynomials with all variables known
> * Evaluation of polynomials with multiple variables

SymExp will suport:
> * Equation and Expression Syntax
> * Partial Evaluation when only some variables are known
> * Algebriac manipulation of Variables

The Current syntax looks like:
```kotlin
val poly = Polynomial(Symbol('x'))
poly.add('4', '3')
poly.add('-1', '3')
println(poly)
println(poly.eval(mapOf('x' to 2.0)))
```
which outputs:

> 4x<sup>3</sup> - x

> 30.0

and for multi-variable:

```kotlin
val poly = Polynomial(Symbol('x'), Symbol('y', 2))
poly.add('4', '3')
poly.add('-1', '3')
println(poly)
println(poly.eval(mapOf('x' to 2.0, 'y' to 3.0)))
```

which evaluates to:

> 4(xy<sup>2</sup>)<sup>3</sup> - xy<sup>2</sup>
> 23310.0

In the future SymExp will have various extension libraries for subjects like diffrential calculus and linear algebra
