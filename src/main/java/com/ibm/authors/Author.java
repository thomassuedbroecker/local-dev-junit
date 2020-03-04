package com.ibm.authors;

// JSON-B
import javax.json.bind.annotation.JsonbProperty;

public class Author {

	@JsonbProperty(nillable = true)
	private String name;
	@JsonbProperty(nillable = true)
	private String twitter;
	@JsonbProperty(nillable = true)
	private String blog;
	
	public Author () { 
    };

	public Author (String thename, String theblog, String thetwitter) { name = thename;
				 blog = theblog;
				 twitter = thetwitter;
	};
	
	public String getBlog() { return blog; };
	public String getName() { return name; };
	public String getTwitter() { return twitter;};
	public void setBlog(String blog) { this.blog = blog;};
	public void setName(String name) { this.name = name; };
	public void setTwitter(String twitter) { this.twitter = twitter;};
}