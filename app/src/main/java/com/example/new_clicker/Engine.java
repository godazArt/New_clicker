package com.example.new_clicker;

import java.text.DecimalFormat;
import java.util.function.DoubleToIntFunction;

public class Engine {
    double  click_power = 1, click_per_second = 0, total_score = 0, balance = 0, multipler = 1;
    DecimalFormat df = new DecimalFormat(".###");
    void click_action()
    {
        double temp = click_power * multipler;
        balance += temp;
        total_score += temp;
    }

    String get_balance()
    {
        return ( (int)balance != balance) ? df.format(balance) + "" : (int)balance + "";
    }
}
