package com.team3.business.handler;

import com.team3.business.exception.BaseballLeagueException;
import com.team3.business.exception.ExceptionMessages;
import com.team3.business.models.Address;
import com.team3.business.models.Division;
import com.team3.business.models.Field;
import com.team3.business.models.League;
import com.team3.business.models.Payment;
import com.team3.business.models.Phone;
import com.team3.business.models.Player;
import com.team3.business.models.Season;
import com.team3.business.models.Team;
import com.team3.business.models.User;

public class BaseballLegueHandler 
{
	public void isValidUser(User user) throws BaseballLeagueException {
		if(user.getUserName().length() > 25 || user.getUserPassword().length() > 25 || user.getUserEmail().length() > 25
				|| user.getUserName().isEmpty() || user.getUserPassword().isEmpty() || user.getUserEmail().isEmpty()){
			throw new BaseballLeagueException(ExceptionMessages.VALIDATION_EXCEPTION_MESSAGE, ExceptionMessages.VALIDATION_EXCEPTION_TITLE);
		}
	}
	
	public void isValidTeam(Team team) throws BaseballLeagueException {
		if(team.getTeamTitle().length() > 50 || team.getTeamNumPlayers() == 0 || team.getTeamTitle().isEmpty()) {
			throw new BaseballLeagueException(ExceptionMessages.VALIDATION_EXCEPTION_MESSAGE, ExceptionMessages.VALIDATION_EXCEPTION_TITLE);
		}
	}
	
	public void isValidSeason(Season season) throws BaseballLeagueException {
		if(season.getSeasonName().length() > 50 || season.getSeasonName().isEmpty() || season.getStartDate() == null || season.getEndDate() == null || season.getNumPlayer() == 0) {
			throw new BaseballLeagueException(ExceptionMessages.VALIDATION_EXCEPTION_MESSAGE, ExceptionMessages.VALIDATION_EXCEPTION_TITLE);
		}
	}
	
	public void isValidPlayer(Player player) throws BaseballLeagueException {
		if(player.getFirstName().length() > 25 || player.getFirstName().isEmpty() || player.getLastName().length() > 25 || player.getLastName().isEmpty() || player.getMiddleName().length() > 25 || player.getDateOfBirth() == null) {
			throw new BaseballLeagueException(ExceptionMessages.VALIDATION_EXCEPTION_MESSAGE, ExceptionMessages.VALIDATION_EXCEPTION_TITLE);
		}
	}
	
	public void isValidPhone(Phone phone) throws BaseballLeagueException {
		if(phone.getPhoneNum().isEmpty()) {
			throw new BaseballLeagueException(ExceptionMessages.VALIDATION_EXCEPTION_MESSAGE, ExceptionMessages.VALIDATION_EXCEPTION_TITLE);
		}
	}
	
	public void isValidPayment(Payment payment) throws BaseballLeagueException {
		if(payment.getCardNumber().length() > 50 || payment.getCardNumber().isEmpty() || payment.getCardNumber().isEmpty() || payment.getExpDate() == null || payment.getCvvCode().isEmpty()) {
			throw new BaseballLeagueException(ExceptionMessages.VALIDATION_EXCEPTION_MESSAGE, ExceptionMessages.VALIDATION_EXCEPTION_TITLE);
		}
	}
	
	public void isValidLegue(League league) throws BaseballLeagueException {
		if(league.getLeagueName().length() > 50 || league.getLeagueName().isEmpty() || league.getLeagueLocation().isEmpty() || league.getLeagueLocation().length() > 50) {
			throw new BaseballLeagueException(ExceptionMessages.VALIDATION_EXCEPTION_MESSAGE, ExceptionMessages.VALIDATION_EXCEPTION_TITLE);
		}
	}
	
	public void isValidField(Field field) throws BaseballLeagueException {
		if(field.getFieldName().length() > 50 || field.getFieldName().isEmpty() || field.getFieldLocation().isEmpty() || field.getFieldLocation().length() > 50) {
			throw new BaseballLeagueException(ExceptionMessages.VALIDATION_EXCEPTION_MESSAGE, ExceptionMessages.VALIDATION_EXCEPTION_TITLE);
		}
	}
	
	public void isValidDivision(Division division) throws BaseballLeagueException {
		if(division.getDivisionTitle().length() > 50 || division.getDivisionTitle().isEmpty() || division.getDivisionMinAge() == null || division.getDivisionMaxAge() == null || division.getDivisionNumPlayers() == null) {
			throw new BaseballLeagueException(ExceptionMessages.VALIDATION_EXCEPTION_MESSAGE, ExceptionMessages.VALIDATION_EXCEPTION_TITLE);
		}
	}
	
	public void isValidAddress(Address address) throws BaseballLeagueException {
		if(address.getAddressLine1().length() > 25 || address.getAddressLine1().isEmpty() || address.getAddressLine2().length() > 25 || address.getAddressLine2().isEmpty() || address.getCity().length() > 25 || address.getCity().isEmpty() || address.getState().length() > 2 || address.getState().isEmpty() || address.getZip().isEmpty()) {
			throw new BaseballLeagueException(ExceptionMessages.VALIDATION_EXCEPTION_MESSAGE, ExceptionMessages.VALIDATION_EXCEPTION_TITLE);
		}
	}
}
