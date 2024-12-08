package org.kurron.logging.logging;

import org.testcontainers.utility.DockerImageName;
import org.testcontainers.vault.VaultContainer;

/**
 * A version of VaultContainer that gets around VaultContainer's use of Java generics that does not play well with Spring.
 */
public class CustomVaultContainer extends VaultContainer<CustomVaultContainer> {

    public CustomVaultContainer(DockerImageName dockerImageName) {
        super(dockerImageName);
    }

    public CustomVaultContainer(String dockerImageName) {
        super(dockerImageName);
    }

}
