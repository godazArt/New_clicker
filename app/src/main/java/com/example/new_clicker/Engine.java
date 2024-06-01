package com.example.new_clicker;

import java.text.DecimalFormat;
import java.util.function.DoubleToIntFunction;

public class Engine {
    double  click_power = 10, click_per_second = 0, balance = 0, multipler = 1;
    int degree = 0;
    DecimalFormat df = new DecimalFormat(".###");
    void balance_change(double n)
    {
        balance += n;
        if(balance > 1000)
        {
            degree +=1;
            balance /= 1000.;
        }
        else if(balance < 1)
        {
            degree -= 1;
            balance *= 1000;
        }
    }
    void click_action()
    {
        double temp = click_power * multipler /  Math.pow(10,3 * degree);
        balance_change(temp);
    }

    String get_balance()
    {
        if (degree == 0)
            return ( (int)balance != balance) ? df.format(balance) + "" : (int)balance + "";
        else
            return ( (int)balance != balance) ? df.format(balance) + " * 10^" + 3 * degree: (int)balance + " * 10^" + 3 * degree;
    }
}
