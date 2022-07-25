package br.com.danieldias.aws.tools.camel.service;



import br.com.danieldias.aws.tools.camel.dto.secretmanager.SecretListEntryDTO;

import java.util.List;

public interface SecretsManagerCall {

    public List<SecretListEntryDTO> listSecrets();
    public String getSecret();
    public SecretListEntryDTO describeSecret();
}
