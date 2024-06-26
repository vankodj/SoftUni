package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.AddOfferDto;
import bg.softuni.mobilele.service.BrandService;
import bg.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Path;
import javax.validation.Valid;

@Controller
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService
                   , BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/offers/all")
    public String allOffers() {
        return "/offers";
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model){
        if (!model.containsAttribute("addOfferModel")){
            model.addAttribute("addOfferModel",new AddOfferDto());
        }
        model.addAttribute("brands",brandService.getAllBrands());
        return "/offer-add";
    }

    @GetMapping("/offers/{id}/details")
    public String details(@PathVariable("id") String id){
        return "details";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid AddOfferDto addOfferModel
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addOfferModel",addOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",bindingResult);
            return "redirect:/offers/add";
        }
     offerService.addOffer(addOfferModel);

        return "redirect:/offers/all";
    }
}
