import zio.http.*
import zio.*

object Main extends ZIOAppDefault:
  val routes = Routes(
    Method.GET / Root -> handler(Response.text("Ciao da ZIO HTTP (Scala 3) su Render! 🚀")),
    Method.GET / "saluta" / string("name") -> handler { (name: String) =>
      Response.text(s"Ciao, $name!")
    }
  )

  val server = Server.serve(routes).provide(Server.defaultWithPort(8080))

  def run = server