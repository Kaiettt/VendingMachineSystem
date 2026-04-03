package org.example.interfaces;

import org.example.models.StockAlertData;

import java.util.List;

public interface ISubscriber
{
    void Notify(List<StockAlertData> dataList);
}