package reviewssitefullstack;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;

	private String tagName;

	@ManyToMany(mappedBy = "tags")
	private Set<Review> reviewsOnTags;

	protected Tag() {

	}

	public Tag(String tagName) {
		this.tagName = tagName;
	}

	public Long getId() {
		return id;
	}

	public String getTagName() {
		return tagName;
	}

	public Set<Review> getReviewsOnTags() {
		return reviewsOnTags;
	}

	@Override
	public String toString() {
		return tagName;
	}

} // close
