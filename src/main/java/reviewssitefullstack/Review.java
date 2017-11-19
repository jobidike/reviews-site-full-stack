package reviewssitefullstack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Set<Tag> tags;

	private String image;
	private String date;

	@Lob
	private String synopsis;

	protected Review() {

	}

	public Review(String name, Category category, String image, String date, String synopsis, Tag... tag) {
		this.name = name;
		this.category = category;
		this.image = image;
		this.date = date;
		this.synopsis = synopsis;
		this.tags = new HashSet<Tag>(Arrays.asList(tag));

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public String getImage() {
		return image;
	}

	public String getDate() {
		return date;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public Set<Tag> getTag() {
		return tags;
	}

	public void addTagName(Tag tag) {
		tags.add(tag);
		
	}

	public void removeTag(Tag tag) {
		tags.remove(tag);
		
	}
	

//	public void removeTagName(Tag removeTag) {
//		tags.add(removeTag);
//		
//	}

//	public void removeTagName(Tag tag ) {
//		tags.delete();
//		
//	}

} // close
