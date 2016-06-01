package main.groovy.application.controller

import main.groovy.application.dao.CoconutRepository
import main.groovy.application.dao.DocumentRepository
import main.groovy.application.model.Document
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import javax.validation.Valid

@Controller
class CoconutController {

    public static final String ACTION_SAVE = "save"
    public static final String VIEW_COCONUTS = "coconuts"
    public static final String VIEW_ERROR = "error_view"
    public static final String REDIRECT_COCONUTS = "redirect:/s"

    @Autowired
    CoconutRepository coconutRepository

    @Autowired
    DocumentRepository documentRepository

    private static final Logger logger = LoggerFactory.getLogger(CoconutController.class);

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    String getAllDocuments(Map<String, Object> model,
                           @RequestParam(value = "id", required = false) String id) {
        logger.info("Found all documents...")

        if (id != null) {
            Document document = documentRepository.findOne(id as Integer);

            if (document == null) {
                logger.error("Can't find document with ${id}!")
                return VIEW_ERROR
            }
            model.put("document", document);
            logger.info("Editing document with id ${id}...")
        }

        model.put("documents", documentRepository.findAll())
        return VIEW_COCONUTS
    }

    @RequestMapping(value = "/s", method = RequestMethod.GET)
    String createNewDoc(Model model,
                        @RequestParam(value = "id", required = false) String id) {

        logger.info("createNewDoc() reached...")

        ArrayList<Document> documents = documentRepository.findAll();
        model.addAttribute("documents", documents);

        for (Document document : documents) {
            logger.info("Document: " + documents)
        }

        model.addAttribute("document", new Document());

        return VIEW_COCONUTS
    }

    @RequestMapping(value = "/delete")
    String deleteDocument(@RequestParam(value = "id", required = false) String id) {

        logger.info("getAllCoconuts() reached...")

        if (id != null) {

            Document document = documentRepository.findOne(id as Integer);
            logger.info("Found your document...")

            logger.info("Trying to delete...")
            documentRepository.delete(document)
            REDIRECT_COCONUTS

        }

        return "documents"
    }


    @RequestMapping(value = "/s", method = RequestMethod.POST)
    String updateCoconuts(@RequestParam("action") String action,
                          @Valid @ModelAttribute("document") Document document,
                          BindingResult bindingResult,
                          Map<String, Object> model) {

        logger.info("Updating model...")

        if (bindingResult.hasErrors()) {
            logger.error("Errors!")
            model.put("model", document)
            return "documents"
        }

        if (ACTION_SAVE.equals(action)) {
            documentRepository.save(document)
        }

        model.put("documents", documentRepository.findAll())

        return REDIRECT_COCONUTS
    }

    @RequestMapping(value = "/coconutservice/add", method = RequestMethod.POST)
    String addCoconut(@ModelAttribute("document") Document document) {
        logger.info("Document adding controller reached...")

        Document savedDocument = documentRepository.save(document);
        if (savedDocument != null) {
            return REDIRECT_COCONUTS;
        }

        return VIEW_ERROR;
    }
}