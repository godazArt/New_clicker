package com.example.new_clicker;

public class Engine {
    double  click_power = 1, click_per_second = 0, total_score = 0, balance = 0, multipler = 1;

    void click_action()
    {
        balance += click_power * multipler;
    }

    double get_balance()
    {
        return balance;
    }
}
