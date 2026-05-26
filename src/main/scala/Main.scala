import zio.http.*
import zio.*

object Main extends ZIOAppDefault:
  val app: HttpApp[Any] = Http.collect[Request]:
    case Method.GET -> Root =>
      Response.text("Ciao da ZIO HTTP (Scala 3) su Render! 🚀")
    case Method.GET -> Root / "saluta" / name =>
      Response.text(s"Ciao, $name!")

  val server = Server.serve(app).provide(Server.defaultWithPort(8080))

  def run = server