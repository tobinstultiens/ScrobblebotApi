package com.scrobblebots.scrobblebotapi;

import com.scrobblebots.scrobblebotapi.models.User;
import com.scrobblebots.scrobblebotapi.repositories.UserRepository;
import com.scrobblebots.scrobblebotapi.services.UserService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
class ScrobblebotapiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void TestUserService_AddUser_Success(){
		//Arrange
		var moc = mock(UserRepository.class);
		User user = new User();
		user.setDiscordUsername("kick1999");
		user.setLastFmUsername("kick1999");
		when(moc.save(user)).thenReturn(user);
		UserService userService = new UserService(moc);

		//Act
		var result = userService.AddUser(user);

		//Assert
		Assert.hasText(result.getDiscordUsername(), user.getDiscordUsername());
	}

	@Test
	void TestUserService_AddUser_Fail(){
		//Arrange
		var moc = mock(UserRepository.class);
		when(moc.save(null)).thenReturn(null);
		UserService userService = new UserService(moc);

		//Act
		try{
			userService.AddUser(null);
		}
		catch (Exception e){

		}

		//Assert
		verify(moc).save(null);
	}

	@Test
	void TestUserService_GetUser_Success(){
		//Arrange
		var moc = mock(UserRepository.class);
		User user = new User();
		user.setDiscordUsername("kick1999");
		user.setLastFmUsername("kick1999");
		when(moc.findById(user.getDiscordUsername()).get()).thenReturn(user);
		UserService userService = new UserService(moc);

		//Act
		var result = userService.GetUser("kick1999");

		//Assert
		Assert.hasText(result.getDiscordUsername(), "kick1999");
	}

	@Test
	void TestUserService_GetUser_Fail(){
		//Arrange
		var moc = mock(UserRepository.class);
		when(moc.findById("")).thenThrow(new NoSuchElementException());
		UserService userService = new UserService(moc);

		//Act
		try{
			userService.GetUser("");
		}
		catch (Exception e){

		}


		//Assert
		verify(moc).findById("");
	}

	@Test
	void TestUserService_UpdateUser_Success(){
		//Arrange
		var moc = mock(UserRepository.class);
		User user = new User();
		user.setDiscordUsername("kick1999");
		user.setLastFmUsername("kick1999");
		Optional<User> optionalUser = Optional.of(user);

		when(moc.findById(user.getDiscordUsername())).thenReturn(optionalUser);
		when(moc.save(user)).thenReturn(user);
		UserService userService = new UserService(moc);

		//Act
		var result = userService.UpdateUser(user);

		//Assert
		Assert.hasText(result.getDiscordUsername(), "kick1999");
	}

	@Test
	void TestUserService_UpdateUser_Fail(){
		//Arrange
		var moc = mock(UserRepository.class);
		User user = new User();
		user.setDiscordUsername("kick1999");
		user.setLastFmUsername("kick1999");
		Optional<User> optionalUser = Optional.of(user);

		when(moc.findById(user.getDiscordUsername())).thenReturn(optionalUser);
		when(moc.save(user)).thenReturn(user);
		UserService userService = new UserService(moc);

		//Act
		var result = userService.UpdateUser(user);

		//Assert
		Assert.hasText(result.getDiscordUsername(), "kick1999");
	}
}
