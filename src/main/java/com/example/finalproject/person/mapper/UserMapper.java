package com.example.finalproject.person.mapper;


import com.example.finalproject.person.dto.UserResponse;
import com.example.finalproject.person.model.Employee;


/**
 * Статические методы хорошо, но более правильным будет все таки пометить этот класс как сервис и внедрять его в те бины,
 * где этот функционал нам действительно нужен (убрав при этом модификатор static). Ну или убрать эти методы в те сущности
 * для которых мы и пишем маппер (например mapToUser - в ДТОшку, а mapToUserDto - в класс сущности).
 * Еще момент классы User и Employee очень похожи между собой - поэтому, я здесь вижу 2 варианта развития:
 * 1. Убрать класс Employee и пользоваться исключительно Userом (в конце концов, дать возможность логиниться в систему
 * пользователям, которых админ будет добавлять в систему - не такая уж и плохая идея, для этого нужно только посидеть
 * над конфигурацией security и ролями)
 * 2. Делать отдельные DTOшки для User и Employee. Даже несмотря на то, что классы очень похожи, иногда может возникнуть
 * потребность изменить, например, функционал User не затрагивая при этом Employee. Плюс к всему  - не будет путаницы,
 * которую я наблюдаю в этом классе.
 */


public class UserMapper {
    //Если уж метод возвращает UserResponse, то и на вход он должен принимать User, а не Employee
    public static UserResponse mapToUserDto(Employee employee){
        return new UserResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    //Тоже самое здесь
    public static Employee mapToUser(UserResponse userDto){
        return new Employee(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }

}

