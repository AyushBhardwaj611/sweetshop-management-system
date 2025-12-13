
@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    static class RegisterRequest {
        public String username;
        public String password;
    }

    @Test
    void registerUser_shouldReturnCreated() throws Exception {
        RegisterRequest request = new RegisterRequest();
        request.username = "testuser";
        request.password = "TestPass123";

        mockMvc.perform(post("/api/auth/register")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }
}