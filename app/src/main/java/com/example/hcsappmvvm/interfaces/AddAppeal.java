package com.example.hcsappmvvm.interfaces;

import com.example.hcsappmvvm.model.Appeal;

public interface AddAppeal {
    <T extends Appeal> void addAppeal(Appeal appeal);
}
