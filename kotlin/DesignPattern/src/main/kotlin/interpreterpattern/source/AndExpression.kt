package interpreterpattern.source

class AndExpression(private val left: Expression, private val right: Expression) : Expression {
    override fun interpret(): Boolean = left.interpret() && right.interpret()
}