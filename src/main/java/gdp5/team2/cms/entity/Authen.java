/**
 * 
 */
package gdp5.team2.cms.entity;

/**
 * @author User
 *
 */
public class Authen {
	private String nameRole;
	private String menu;
	public Authen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Authen(String nameRole, String menu) {
		super();
		this.nameRole = nameRole;
		this.menu = menu;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
}
