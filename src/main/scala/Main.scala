import zio.http._
import zio._

object Main extends ZIOAppDefault:
  val routes = Routes(
    // Route senza parametri: un solo parametro (Request)
    Method.GET / Root -> handler { (req: Request) =>
      Response.text("Ciao da ZIO HTTP (Scala 3) su Render! 🚀")
    },
    // Route con parametro dal path: due parametri (String, Request)
    Method.GET / "saluta" / string("name") -> handler { (name: String, req: Request) =>
      Response.text(s"Ciao, $name!")
    }
  )

  val server = Server.serve(routes).provide(Server.defaultWithPort(8080))

  def run = server