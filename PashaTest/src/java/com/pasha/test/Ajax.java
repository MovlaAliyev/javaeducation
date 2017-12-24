
package com.pasha.test;

import com.pasha.models.Model;
import java.util.List;

public interface Ajax {
    public <T> T build(List <Model> list);
}
