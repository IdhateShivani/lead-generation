//package com.example;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class SuperAdminPost {
//
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;
//
// private String title;
// private String description;
// private String image;
// private String date;
// private String time;
// private String referralLink;
//public Long getId() {
//	return id;
//}
//public void setId(Long id) {
//	this.id = id;
//}
//public String getTitle() {
//	return title;
//}
//public void setTitle(String title) {
//	this.title = title;
//}
//public String getDescription() {
//	return description;
//}
//public void setDescription(String description) {
//	this.description = description;
//}
//public String getImageUrl() {
//	return image;
//}
//public void setImageUrl(String imageUrl) {
//	this.image = imageUrl;
//}
//public String getDate() {
//	return date;
//}
//public void setDate(String date) {
//	this.date = date;
//}
//public String getTime() {
//	return time;
//}
//public void setTime(String time) {
//	this.time = time;
//}
//public String getReferralLink() {
//	return referralLink;
//}
//public void setReferralLink(String referralLink) {
//	this.referralLink = referralLink;
//}
//
//
// 
//}

package com.example;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class SuperAdminPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String department;
    private String image; 
   
    private String date;
    private String time;
    private String amount;
    

    // Getters and Setters
    

    public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public Long getId() {
        return id;
    }

   
	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
//
//    public String generateReferralLink() {
//        return "http://localhost:8080/refer/" + id; // Adjust this for your actual domain
//    }
//
//	public void setReferralLink(String referralLink) {
//		// TODO Auto-generated method stub
//		
//	}

	public void setImageUrl(String string) {
		// TODO Auto-generated method stub
		
	}


	public void setReferralLink(String referralLink) {
		// TODO Auto-generated method stub
		
	}
}

