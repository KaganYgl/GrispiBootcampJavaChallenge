package com.kodgemisi.filter;

import com.kodgemisi.usermanagement.User;
import com.kodgemisi.usermanagement.UserService;

import java.util.List;

public class FilterApiImpl implements FilterApi {

	private final UserService userService;

	public FilterApiImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<User> unverifiedUnder18() {
		//FIXME currently returns all the users unfiltered, you should fix this method
		// If you are not sure how to implement this method, please refer to the Javadoc or the FilterApi interface
		List<User> filteredList = userService.list();
		for(int i = 0 ; i < filteredList.size() ; i++){
			if(filteredList.get(i).isVerified() || filteredList.get(i).getAge() >= 18){
				filteredList.remove(i);
				i--;
			}
		}
		return filteredList;
	}

	@Override
	public List<User> verifiedWithTrPrimaryPhone() {
		//FIXME currently returns all the users unfiltered, you should fix this method
		// If you are not sure how to implement this method, please refer to the Javadoc or the FilterApi interface
		List<User> filteredList = userService.list();
		for(int i = 0 ; i < filteredList.size() ; i++){
			if(filteredList.get(i).isVerified() && filteredList.get(i).getProfile().getPrimaryPhone().toString().substring(0,3).equals("+90")){
				continue;
			}else{
				filteredList.remove(i);
				i--;
			}
		}
		return filteredList;	}
}
