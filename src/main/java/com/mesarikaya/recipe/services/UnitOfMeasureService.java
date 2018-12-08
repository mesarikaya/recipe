package com.mesarikaya.recipe.services;

import com.mesarikaya.recipe.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    public Set<UnitOfMeasureCommand> listAllUoms();

}
