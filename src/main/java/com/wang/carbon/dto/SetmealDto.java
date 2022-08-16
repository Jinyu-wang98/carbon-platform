package com.wang.carbon.dto;

import com.wang.carbon.entity.Setmeal;
import com.wang.carbon.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
