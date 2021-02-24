package com.leonino.appweb.repository;

import com.leonino.appweb.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    final List<Jedi> jedieis = new ArrayList<Jedi>();

    public JediRepository() {
        jedieis.add(new Jedi("Luke", "skywalker"));
    }

    public List<Jedi> getAllJedi() {
        return jedieis;
    }

    public void addJedi(Jedi jedi) {
        jedieis.add(jedi);
    }
}
