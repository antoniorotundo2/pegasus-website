import zio.http._
import zio._

object Main extends ZIOAppDefault:
  val routes = Routes(
    Method.GET / Root -> Handler.succeed(Response.text("Ciao da ZIO HTTP (Scala 3) su Render! 🚀")),
    Method.GET / "saluta" / string("name") -> Handler.fromFunctionZIO[String] { name =>
      ZIO.succeed(Response.text(s"Ciao, $name!"))
    }
  )

  val server = Server.serve(routes).provide(Server.defaultWithPort(8080))

  def run = server