package org.activiti.editor.language;

import java.io.InputStream;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public abstract class AbstractConverterTest {

  protected BpmnModel readJsonFile() throws Exception {
    InputStream jsonStream = this.getClass().getClassLoader().getResourceAsStream(getResource());
    JsonNode modelNode = new ObjectMapper().readTree(jsonStream);
    BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(modelNode);
    return bpmnModel;
  }
  
  protected abstract String getResource();
}
