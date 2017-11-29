package es.luisusr.miru.web;
import es.luisusr.miru.Tarea;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tareas")
@Controller
@RooWebScaffold(path = "tareas", formBackingObject = Tarea.class)
public class TareaController {
}
