package ec.edu.sudamericano.piensa.response

class ErrorResponse (
    val status: String = "error",
    val message: String? = null,
    val code: Int? = null
)