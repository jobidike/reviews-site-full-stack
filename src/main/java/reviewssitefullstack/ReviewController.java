package reviewssitefullstack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Resource
	private TagRepository tagRepo;

	@RequestMapping("/categories")
	public String showAllCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		// model.addAttribute("allTags", tagRepo.findAll());
		return "categories";
	}

	@RequestMapping("/category")
	public String showOneCategory(@RequestParam Long id, Model model) {
		model.addAttribute("category", categoryRepo.findOne(id));
		return "category";
	}

	@RequestMapping("/reviews")
	public String getAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/review")
	public String showOneReview(@RequestParam Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		return "review";
	}

	@RequestMapping("/tags")
	public String showAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("/tag")
	public String showOneTag(@RequestParam Long id, Model model) {
		model.addAttribute("tag", tagRepo.findOne(id));
		return "tag";
	}

	@RequestMapping("/add-tag")
	public String addTag(String tagName) {
		Tag newTag = new Tag(tagName);
		tagRepo.save(newTag);
		return "redirect:/tags";
	}

	@RequestMapping("/remove-tag")
	public String removeTag(Long id) {
		Tag removeTag = tagRepo.findOne(id);
		tagRepo.delete(removeTag);
		return "redirect:/tag";
	}

} // close
