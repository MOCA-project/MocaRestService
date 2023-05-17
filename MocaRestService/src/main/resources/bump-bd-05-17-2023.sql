CREATE TABLE [dbo].[cartao](
    [id_cartao] [bigint] IDENTITY(1,1) NOT NULL,
    [limite] [decimal](8, 2) NULL,
    [id_cliente] [bigint] NULL,
    [id_tipo] [bigint] NULL,
    [id_cor_cartao] [bigint] NULL,
    [bandeira] [varchar](50) NULL,
    [apelido] [varchar](50) NULL,
    [vencimento] [char](5) NULL,
    PRIMARY KEY CLUSTERED
(
[id_cartao] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[cliente]    Script Date: 5/17/2023 7:24:29 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[cliente](
    [id] [bigint] IDENTITY(1,1) NOT NULL,
    [nome] [varchar](100) NULL,
    [email] [varchar](100) NULL,
    [senha] [varchar](100) NULL,
    [id_perfil] [bigint] NULL,
    [ultimo_acesso] [date] NULL,
    [telefone] [char](11) NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[cor_cartao]    Script Date: 5/17/2023 7:24:29 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[cor_cartao](
    [id_cor_cartao] [bigint] IDENTITY(1,1) NOT NULL,
    [hexadecimal] [varchar](50) NOT NULL,
    [nome] [varchar](50) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[id_cor_cartao] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[despesa]    Script Date: 5/17/2023 7:24:29 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[despesa](
    [id_despesa] [bigint] IDENTITY(1,1) NOT NULL,
    [descricao] [varchar](100) NULL,
    [valor] [decimal](10, 2) NULL,
    [data] [date] NULL,
    [is_paid] [bit] NULL,
    [is_parcela] [bit] NULL,
    [id_cliente] [bigint] NULL,
    [id_tipo_despesa] [bigint] NULL,
    [is_cartao] [bit] NULL,
    [id_cartao] [bigint] NULL,
    PRIMARY KEY CLUSTERED
(
[id_despesa] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[porquinho]    Script Date: 5/17/2023 7:24:29 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[porquinho](
    [id_porquinho] [bigint] IDENTITY(1,1) NOT NULL,
    [nome] [varchar](100) NULL,
    [valor_final] [decimal](10, 2) NULL,
    [valor_atual] [decimal](10, 2) NULL,
    [is_concluido] [bit] NULL,
    [id_cliente] [bigint] NULL,
    PRIMARY KEY CLUSTERED
(
[id_porquinho] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[receita]    Script Date: 5/17/2023 7:24:29 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[receita](
    [id_receita] [bigint] IDENTITY(1,1) NOT NULL,
    [descricao] [varchar](100) NULL,
    [valor] [decimal](10, 2) NULL,
    [data] [date] NULL,
    [id_cliente] [bigint] NULL,
    [id_tipo_receita] [bigint] NULL,
    PRIMARY KEY CLUSTERED
(
[id_receita] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[tp_cartao]    Script Date: 5/17/2023 7:24:29 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[tp_cartao](
    [id_tp_cartao] [bigint] IDENTITY(1,1) NOT NULL,
    [descricao] [varchar](100) NULL,
    PRIMARY KEY CLUSTERED
(
[id_tp_cartao] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[tp_despesa]    Script Date: 5/17/2023 7:24:29 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[tp_despesa](
    [id_tp_despesa] [bigint] IDENTITY(1,1) NOT NULL,
    [descricao] [varchar](100) NULL,
    PRIMARY KEY CLUSTERED
(
[id_tp_despesa] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[tp_perfil]    Script Date: 5/17/2023 7:24:29 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[tp_perfil](
    [id_tp_perfil] [bigint] IDENTITY(1,1) NOT NULL,
    [nome_perfil] [varchar](100) NULL,
    PRIMARY KEY CLUSTERED
(
[id_tp_perfil] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[tp_receita]    Script Date: 5/17/2023 7:24:29 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[tp_receita](
    [id_tp_receita] [bigint] IDENTITY(1,1) NOT NULL,
    [descricao] [varchar](100) NULL,
    PRIMARY KEY CLUSTERED
(
[id_tp_receita] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
    SET IDENTITY_INSERT [dbo].[cartao] ON
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (1, CAST(5000.00 AS Decimal(8, 2)), 45, 1, 1, N'Mastercard', N'Cartão da Mae', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (2, CAST(800.00 AS Decimal(8, 2)), 54, 2, 1, NULL, N'NuBank', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (3, CAST(1500.00 AS Decimal(8, 2)), 61, 1, 1, N'VISA', N'Cartão Genial', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (4, CAST(1500.00 AS Decimal(8, 2)), 62, 1, 1, N'VISA', N'Cartão Genial', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (5, CAST(100.00 AS Decimal(8, 2)), 73, 1, 1, N'string', N'string', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (6, CAST(1000.00 AS Decimal(8, 2)), 75, 1, 1, N'string', N'string', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (7, CAST(1000.00 AS Decimal(8, 2)), 80, 1, 1, N'string', N'string', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (8, CAST(1000.00 AS Decimal(8, 2)), 81, 1, 1, N'string', N'string', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (9, CAST(1000.00 AS Decimal(8, 2)), 82, 1, 1, N'string', N'string', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (10, CAST(1000.00 AS Decimal(8, 2)), 83, 1, 1, N'Visa', N'Nubank', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (11, CAST(800.00 AS Decimal(8, 2)), 74, 2, 5, N'Mastercard', N'Cartão', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (12, CAST(1000.00 AS Decimal(8, 2)), 74, 2, 4, N'Visa', N'Bradesco Cartão', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (13, CAST(1200.00 AS Decimal(8, 2)), 74, 2, 1, N'Visa', N'C6 Cartão', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (14, CAST(900.00 AS Decimal(8, 2)), 74, 2, 3, N'Elo', N'Itau cartao', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (15, CAST(2000.00 AS Decimal(8, 2)), 74, 2, 6, N'Mastercard', N'Inter cartão', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (16, CAST(2500.00 AS Decimal(8, 2)), 74, 2, 2, N'Visa', N'Pan cartão', N'11/25')
    GO
    INSERT [dbo].[cartao] ([id_cartao], [limite], [id_cliente], [id_tipo], [id_cor_cartao], [bandeira], [apelido], [vencimento]) VALUES (18, CAST(3000.00 AS Decimal(8, 2)), 74, 2, 2, N'Elo', N'Pan', N'10/25')
    GO
    SET IDENTITY_INSERT [dbo].[cartao] OFF
    GO
    SET IDENTITY_INSERT [dbo].[cliente] ON
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (45, N'Alexandre Costa', N'ale@gmail.com', N'123', 1, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (54, N'Gustavo Carriel', N'gu@gmail.com', N'123', 1, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (56, N'Gustavo Almeida', N'gu@gmail.com', N'123', 1, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (57, N'Alexandre Costa', N'lele@gmail.com', N'$2a$10$PeEa5KzOKgkqwjWktAi8leb/amsByQY9vtqXMDHgjeUvObuWA6PKW', 1, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (58, N'Diogo', N'diogo@email.com', N'$2a$10$fjM95pR0Ij/3v9LXcnm86.RSWXHD6D8vJ2lgweT6/28ExcAI9IOlq', 1, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (59, N'Gustavo', N'gu@email.com', N'$2a$10$4SJac3H4PnCuWM1K4xXOXugku5JE.vjFsSylVLVh.ye4bX0cj.TgG', 1, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (60, N'Gustavo', N'alexandre.rodrigues@sptech.school', N'$2a$10$qKfjYwm040f../dzy6PzleBNIPutaLQvOkpdfFPbwzY6J6zygx4Me', 1, CAST(N'2020-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (61, N'Teste', N'teste@email.com', N'$2a$10$cnb/YOpnlnIBg2ic8qzIb..D5DtMUNIOIH3ubtVWSPT69d6z/GlAm', 2, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (62, N'Teste', N'teste2@email.com', N'$2a$10$//tJakuxCUzgbwPJtjNIiOt8RZLV9DtNJt3KUuWpp0wGojoQonBnq', 2, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (63, N'Gustavo', N'gusta@gmail.com', N'$2a$10$S9.kbB0U3.1f3M4uYqJ9v.MM8Ss8SQ2JDcw9m0kFBuGkgmtPSXFxS', 5, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (64, N'teste', N'teste3@gmail.com', N'$2a$10$Fa0AQj4Fq3BAlX9eRs8kd.hCbwZ3YRvPsP04VjPvCn/WwgAnZTOPC', 5, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (65, N'teste', N'teste4@email.com', N'$2a$10$UIo65Vq07aPvjIDB1j5pFexHXbKYMLDp9XvTLXk9pwhnrBxo9aEHC', 5, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (66, N'teste', N'teste5@email.com', N'$2a$10$IRuyeWJdX1BfquU/GslPceN/Alsx4bglFNz2HEUFNOJQreGfju.J.', 5, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (67, N'teste', N'teste6@email.com', N'$2a$10$QEgjo9xD/rdU8pmwN/g9g.bPpsQqF9ckx8PxV4dDch4fB1gtmefuW', 5, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (68, N'teste', N'teste7@email.com', N'$2a$10$Qym/gIql9V89AImaEbYImuxtpbSZiA4oFQAuI5VW8VhqsKylhFIi.', 5, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (69, N'teste', N'teste8@email.com', N'$2a$10$IehLapUyXBIRmqGe9WkMJeXRxRnAV80p/o./QdMV5R5IrTJR/v2tO', 5, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (70, N'teste', N'teste9@email.com', N'$2a$10$3lH/Bh6SL2c/3VLL6sXPF.mkCvGZRo.d/IIN66aaTEc7OgduQawJK', 5, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (71, N'Alexandre Costa', N'alecosta.gg2@gmail.com', N'$2a$10$riqC5kYWzaYml0fkEaY4Ber2tJGSGH9nrcDJWRW9dQZQ3a0b5vAZq', 5, CAST(N'2023-04-25' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (72, N'dasdas', N'aaa@gmail.com', N'$2a$10$GPLwu9P.qDQk984FLJtyOe6xeyS2wRDCZVpPFacqMaq43nTU8M3rO', 5, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (73, N'Async', N'async@email.com', N'$2a$10$s3/NF1Vhrm6wYkLiTbkM7O1y2gGhiEUorXnT0ut.70YXg5eISAf6C', 5, CAST(N'2022-01-01' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (74, N'Gustavo Carriel', N'gustavo.carriel@hotmail.com', N'$2a$10$xi.fhGA0gJb0vIwLWq12CO/DFHr3eaV01UBQqL0RzUu9HLMsoXvPS', 5, CAST(N'2023-04-28' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (75, N'string', N'raul@email.com', N'$2a$10$.WgGOlE6Lk/Ne92XTWECvOBF30jwgTc.bP.JU3TLD7gbaDfnMhvgW', 5, CAST(N'2023-04-24' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (76, N'Alexandre', N'aleale@email.com', N'$2a$10$N8G1OlZI6a9mQTfu63mzjOmb6Kgm1PJMUXymY54HEHy7Bup.9XPH2', 5, CAST(N'2020-01-01' AS Date), NULL)
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (78, N'Gustavo', N'carriel@gmail.com', N'$2a$10$NPeVT0gVqvKsJHDCivEob.ezWCQCzcyT6tB6AF5tzlLmjmZ9958Vu', 5, CAST(N'2020-01-01' AS Date), N'11953860412')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (79, N'Gustavo', N'carriel@email.com', N'$2a$10$LoHFVS17/i1B/x/P/aVqA.S04U/KXtErFGBaWVSPBCof9AARE30a6', 5, CAST(N'2020-01-01' AS Date), N'11953860412')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (80, N'Teste 123', N'aleale2@email.com', N'$2a$10$VkFEE4w9Np7Zt1DLXd1pge6C1t8zRXi8kcsAqFw1mWcfL0nPc0tnm', 5, CAST(N'2023-04-26' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (81, N'teste 3', N'aleale3@email.com', N'$2a$10$el8ag3/LXdSiPc1G1jfdnOnZqyNSHYDPbNMsM5nIzfg/1kpxXjrWm', 5, CAST(N'2023-05-17' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (82, N'Auguimar Silva', N'auguimar@gmail.com', N'$2a$10$8jXxIlexvij8/WgPR5wzl.Pfh/Veev69AEJepmCXVKt4mQWJzIyT2', 5, CAST(N'2023-04-27' AS Date), N'11959817061')
    GO
    INSERT [dbo].[cliente] ([id], [nome], [email], [senha], [id_perfil], [ultimo_acesso], [telefone]) VALUES (83, N'Alex Barreira', N'alex@gmail.com', N'$2a$10$ad7ns15.Pm0Kq6A1BOcITOen54AlNacWhALxFQQvMbqMm2d896Qza', 5, CAST(N'2023-04-27' AS Date), N'11959817061')
    GO
    SET IDENTITY_INSERT [dbo].[cliente] OFF
    GO
    SET IDENTITY_INSERT [dbo].[cor_cartao] ON
    GO
    INSERT [dbo].[cor_cartao] ([id_cor_cartao], [hexadecimal], [nome]) VALUES (1, N'#0071C5', N'Azul Royal')
    GO
    INSERT [dbo].[cor_cartao] ([id_cor_cartao], [hexadecimal], [nome]) VALUES (2, N'#50C878', N'Verde Esmeralda')
    GO
    INSERT [dbo].[cor_cartao] ([id_cor_cartao], [hexadecimal], [nome]) VALUES (3, N'#FFD700', N'Amarelo Sol')
    GO
    INSERT [dbo].[cor_cartao] ([id_cor_cartao], [hexadecimal], [nome]) VALUES (4, N'#DC143C', N'Vermelho Cereja')
    GO
    INSERT [dbo].[cor_cartao] ([id_cor_cartao], [hexadecimal], [nome]) VALUES (5, N'#8A2BE2', N'Roxo Violeta')
    GO
    INSERT [dbo].[cor_cartao] ([id_cor_cartao], [hexadecimal], [nome]) VALUES (6, N'#FF7F50', N'Laranja Coral')
    GO
    INSERT [dbo].[cor_cartao] ([id_cor_cartao], [hexadecimal], [nome]) VALUES (7, N'#C0C0C0', N'Cinza Prata')
    GO
    SET IDENTITY_INSERT [dbo].[cor_cartao] OFF
    GO
    SET IDENTITY_INSERT [dbo].[despesa] ON
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (3, N'Blaze', CAST(155.75 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 0, 0, 45, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (4, N'Blaze', CAST(155.75 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 0, 0, 45, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (5, N'Blaze', CAST(155.75 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 0, 0, 45, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (6, N'Blaze', CAST(10.20 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 0, 0, 45, 7, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (7, N'Blaze', CAST(10.20 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 0, 0, 45, 4, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (9, N'Mouse', CAST(250.00 AS Decimal(10, 2)), CAST(N'2023-03-20' AS Date), 0, 1, 45, 1, 1, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (10, N'Mouse', CAST(250.00 AS Decimal(10, 2)), CAST(N'2023-04-20' AS Date), 0, 1, 45, 1, 1, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (11, N'Blaze', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 0, 0, 45, 4, 0, 1)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (12, N'Blaze', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 0, 0, 45, 4, 1, 1)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (13, N'Blaze', CAST(900.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 0, 0, 45, 4, 1, 1)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (14, N'fdsfsdfdsfsdfsdfdsfsdfds', CAST(900.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 0, 0, 45, 4, 1, 1)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (15, N'fdsfsdfdsfsdfsdfdsfsdfds', CAST(900.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 1, 0, 45, 4, 1, 1)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (16, N'sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2023-04-05' AS Date), 0, 0, 54, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (17, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (18, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-05-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (19, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-06-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (20, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-07-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (21, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-08-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (22, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-09-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (23, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-10-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (24, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-11-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (25, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-12-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (26, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-01-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (27, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-02-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (28, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-03-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (29, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-04-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (30, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-05-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (31, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-06-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (32, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-07-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (33, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-08-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (34, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-09-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (35, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-10-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (36, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-11-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (37, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-12-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (38, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2025-01-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (39, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2025-02-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (40, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2025-03-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (41, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (42, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-05-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (43, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-06-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (44, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-07-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (45, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-08-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (46, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-09-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (47, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-10-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (48, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-11-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (49, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2023-12-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (50, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-01-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (51, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-02-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (52, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-03-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (53, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-04-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (54, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-05-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (55, N'dsadsadsa', CAST(0.00 AS Decimal(10, 2)), CAST(N'2023-05-10' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (56, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-07-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (57, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-08-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (58, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-09-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (60, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-11-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (61, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2024-12-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (63, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2025-02-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (64, N'dadasdas', CAST(4.17 AS Decimal(10, 2)), CAST(N'2025-03-12' AS Date), 0, 1, 54, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (65, N'Compra', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 1, 0, 61, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (66, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 0, 1, 61, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (67, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-05-12' AS Date), 0, 1, 61, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (68, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-06-12' AS Date), 0, 1, 61, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (69, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-07-12' AS Date), 0, 1, 61, 2, 1, 2)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (70, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 0, 1, 61, 2, 1, 3)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (71, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-05-12' AS Date), 0, 1, 61, 2, 1, 3)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (72, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-06-12' AS Date), 0, 1, 61, 2, 1, 3)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (73, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-07-12' AS Date), 0, 1, 61, 2, 1, 3)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (74, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 0, 1, 61, 2, 1, 15)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (75, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-05-12' AS Date), 0, 1, 61, 2, 1, 15)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (76, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-06-12' AS Date), 0, 1, 61, 2, 1, 15)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (77, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-07-12' AS Date), 0, 1, 61, 2, 1, 15)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (78, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 0, 1, 61, 2, 1, 3)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (79, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-05-12' AS Date), 0, 1, 61, 2, 1, 3)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (80, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-06-12' AS Date), 0, 1, 61, 2, 1, 3)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (81, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-07-12' AS Date), 0, 1, 61, 2, 1, 3)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (83, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 0, 1, 62, 2, 1, 4)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (84, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-05-12' AS Date), 0, 1, 62, 2, 1, 4)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (85, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-06-12' AS Date), 0, 1, 62, 2, 1, 4)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (86, N'Compra', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-07-12' AS Date), 0, 1, 62, 2, 1, 4)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (87, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (88, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-05-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (89, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-06-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (90, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-07-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (91, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-08-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (92, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-09-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (93, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-10-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (94, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-11-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (95, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-12-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (96, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2024-01-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (97, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2024-02-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (98, N'Despesa fixa', CAST(500.00 AS Decimal(10, 2)), CAST(N'2024-03-12' AS Date), 0, 0, 62, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (99, N'Despesa', CAST(99.50 AS Decimal(10, 2)), CAST(N'2023-04-18' AS Date), 1, 0, 71, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (100, N'Despesa', CAST(99.52 AS Decimal(10, 2)), CAST(N'2023-04-18' AS Date), 1, 0, 71, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (101, N'Despesa', CAST(55.99 AS Decimal(10, 2)), CAST(N'2023-04-18' AS Date), 0, 0, 71, 1, 1, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (102, N'string', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-04-18' AS Date), 1, 0, 71, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (103, N'string', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-04-18' AS Date), 1, 0, 71, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (104, N'string', CAST(200.00 AS Decimal(10, 2)), CAST(N'2023-04-18' AS Date), 0, 0, 71, 2, 1, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (105, N'string', CAST(75.00 AS Decimal(10, 2)), CAST(N'2023-04-23' AS Date), 1, 0, 73, 1, 1, 5)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (106, N'string', CAST(1.00 AS Decimal(10, 2)), CAST(N'2023-04-23' AS Date), 1, 0, 73, 1, 1, 5)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (107, N'string', CAST(1.00 AS Decimal(10, 2)), CAST(N'2023-04-23' AS Date), 1, 0, 73, 1, 1, 5)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (108, N'string', CAST(1.00 AS Decimal(10, 2)), CAST(N'2023-04-23' AS Date), 1, 0, 73, 1, 1, 5)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (109, N'teste dashboard', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-04-24' AS Date), 0, 0, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (110, N'string', CAST(749.00 AS Decimal(10, 2)), CAST(N'2023-04-24' AS Date), 1, 0, 75, 1, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (111, N'string', CAST(2.00 AS Decimal(10, 2)), CAST(N'2023-04-24' AS Date), 1, 0, 75, 1, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (112, N'string', CAST(2.00 AS Decimal(10, 2)), CAST(N'2023-04-24' AS Date), 1, 0, 75, 1, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (113, N'string', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-04-24' AS Date), 1, 0, 75, 1, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (114, N'string', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-04-24' AS Date), 0, 1, 75, 2, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (115, N'string', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-05-24' AS Date), 0, 1, 75, 2, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (116, N'string', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-06-24' AS Date), 0, 1, 75, 2, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (117, N'string', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-07-24' AS Date), 0, 1, 75, 2, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (118, N'string', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-08-24' AS Date), 0, 1, 75, 2, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (119, N'string', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-09-24' AS Date), 0, 1, 75, 2, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (120, N'string', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-10-24' AS Date), 0, 1, 75, 2, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (121, N'string', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-11-24' AS Date), 0, 1, 75, 2, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (122, N'string', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-12-24' AS Date), 0, 1, 75, 2, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (123, N'string', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2024-01-24' AS Date), 0, 1, 75, 2, 1, 6)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (124, N'Faculdade', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (125, N'Aluguem', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (126, N'Aluguem', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (127, N'Aluguel', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (128, N'Aluguel', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (129, N'Aluguel', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (130, N'Aluguel', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (131, N'Aluguel', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (132, N'Aluguel', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (133, N'Aluguel', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (134, N'dsadas', CAST(400.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (135, N'dsadas', CAST(400.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (136, N'dsadas', CAST(400.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 3, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (137, N'dsa', CAST(412.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 0, 0, 76, 8, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (138, N'Monitor', CAST(560.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 0, 74, 6, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (139, N'dsadadas', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 0, 76, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (140, N'dsds', CAST(333.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 0, 76, 4, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (141, N'a', CAST(1.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 0, 76, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (142, N'Consulta', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 1, 0, 80, 4, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (144, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (145, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-05-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (146, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-06-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (147, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-07-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (148, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-08-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (149, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-09-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (150, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-10-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (151, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-11-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (152, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-12-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (153, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2024-01-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (154, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2024-02-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (155, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2024-03-26' AS Date), 0, 0, 76, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (157, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (158, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-05-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (159, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-06-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (160, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-07-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (161, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-08-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (162, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-09-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (163, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-10-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (164, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-11-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (165, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-12-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (166, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2024-01-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (167, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2024-02-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (168, N'Médico', CAST(50.00 AS Decimal(10, 2)), CAST(N'2024-03-26' AS Date), 0, 0, 80, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (169, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (170, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-05-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (171, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-06-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (172, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-07-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (173, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-08-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (174, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-09-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (175, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-10-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (176, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-11-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (177, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-12-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (178, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2024-01-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (179, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (180, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-05-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (181, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-06-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (182, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-07-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (183, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-08-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (184, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-09-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (185, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-10-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (186, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-11-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (187, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-12-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (188, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2024-01-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (189, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (190, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-05-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (191, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-06-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (192, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-07-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (193, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-08-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (194, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-09-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (195, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-10-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (196, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-11-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (197, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-12-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (198, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2024-01-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (199, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (200, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-05-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (201, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-06-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (202, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-07-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (203, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-08-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (204, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-09-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (205, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-10-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (206, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-11-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (207, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2023-12-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (208, N'string', CAST(77.00 AS Decimal(10, 2)), CAST(N'2024-01-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (209, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (210, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-05-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (211, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-06-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (212, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-07-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (213, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-08-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (214, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-09-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (215, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-10-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (216, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-11-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (217, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-12-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (218, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2024-01-26' AS Date), 0, 1, 80, 4, 1, 7)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (219, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 1, 1, 81, 4, 1, 8)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (220, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-05-26' AS Date), 1, 1, 81, 4, 1, 8)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (221, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-06-26' AS Date), 1, 1, 81, 4, 1, 8)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (222, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-07-26' AS Date), 1, 1, 81, 4, 1, 8)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (223, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-08-26' AS Date), 1, 1, 81, 4, 1, 8)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (224, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-09-26' AS Date), 1, 1, 81, 4, 1, 8)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (225, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-10-26' AS Date), 1, 1, 81, 4, 1, 8)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (226, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-11-26' AS Date), 1, 1, 81, 4, 1, 8)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (227, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-12-26' AS Date), 1, 1, 81, 4, 1, 8)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (228, N'string', CAST(50.00 AS Decimal(10, 2)), CAST(N'2024-01-26' AS Date), 1, 1, 81, 4, 1, 8)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (229, N'teste 02 dashboard', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 0, 0, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (230, N'Roupa', CAST(2500.00 AS Decimal(10, 2)), CAST(N'2023-04-27' AS Date), 1, 1, 82, 2, 1, 9)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (231, N'Facul top', CAST(1715.00 AS Decimal(10, 2)), CAST(N'2023-04-27' AS Date), 0, 0, 83, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (232, N'Roupa', CAST(2500.00 AS Decimal(10, 2)), CAST(N'2023-04-27' AS Date), 1, 1, 83, 2, 1, 10)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (234, N'Sptech', CAST(1601.00 AS Decimal(10, 2)), CAST(N'2023-05-10' AS Date), 1, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (235, N'Sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2023-06-10' AS Date), 0, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (236, N'Sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2023-07-10' AS Date), 0, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (237, N'Sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2023-08-10' AS Date), 0, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (238, N'Sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2023-09-10' AS Date), 0, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (239, N'Sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2023-10-10' AS Date), 0, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (240, N'Sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2023-11-10' AS Date), 0, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (241, N'Sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2023-12-10' AS Date), 0, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (242, N'Sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2024-01-10' AS Date), 0, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (243, N'Sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2024-02-10' AS Date), 0, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (244, N'Sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2024-03-10' AS Date), 0, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (245, N'Sptech', CAST(1600.00 AS Decimal(10, 2)), CAST(N'2024-04-10' AS Date), 0, 1, 74, 5, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (246, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2023-05-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (247, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2023-06-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (248, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2023-07-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (249, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2023-08-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (250, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2023-09-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (251, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2023-10-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (252, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2023-11-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (253, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2023-12-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (254, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2024-01-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (255, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2024-02-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (256, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2024-03-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (257, N'VR', CAST(800.00 AS Decimal(10, 2)), CAST(N'2024-04-16' AS Date), 0, 1, 74, 2, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (258, N'Plano amil', CAST(66.67 AS Decimal(10, 2)), CAST(N'2023-05-24' AS Date), 1, 1, 74, 4, 1, 16)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (259, N'Plano amil', CAST(66.67 AS Decimal(10, 2)), CAST(N'2023-06-24' AS Date), 1, 1, 74, 4, 1, 16)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (260, N'Plano amil', CAST(66.67 AS Decimal(10, 2)), CAST(N'2023-07-24' AS Date), 1, 1, 74, 4, 1, 16)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (261, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-05-30' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (262, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-06-30' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (263, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-07-30' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (264, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-08-30' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (265, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-09-30' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (266, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-10-30' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (267, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-11-30' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (268, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-12-30' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (269, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2024-01-30' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (270, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2024-02-29' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (271, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2024-03-30' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (272, N'Aluguel', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2024-04-30' AS Date), 0, 1, 74, 1, 0, NULL)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (274, N'Tatuagem', CAST(727.27 AS Decimal(10, 2)), CAST(N'2023-06-24' AS Date), 1, 1, 74, 10, 1, 12)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (275, N'Tatuagem', CAST(727.27 AS Decimal(10, 2)), CAST(N'2023-07-24' AS Date), 1, 1, 74, 10, 1, 12)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (276, N'Tatuagem', CAST(727.27 AS Decimal(10, 2)), CAST(N'2023-08-24' AS Date), 1, 1, 74, 10, 1, 12)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (277, N'Tatuagem', CAST(727.27 AS Decimal(10, 2)), CAST(N'2023-09-24' AS Date), 1, 1, 74, 10, 1, 12)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (278, N'Tatuagem', CAST(727.27 AS Decimal(10, 2)), CAST(N'2023-10-24' AS Date), 1, 1, 74, 10, 1, 12)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (279, N'Tatuagem', CAST(727.27 AS Decimal(10, 2)), CAST(N'2023-11-24' AS Date), 1, 1, 74, 10, 1, 12)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (280, N'Tatuagem', CAST(727.27 AS Decimal(10, 2)), CAST(N'2023-12-24' AS Date), 1, 1, 74, 10, 1, 12)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (281, N'Tatuagem', CAST(727.27 AS Decimal(10, 2)), CAST(N'2024-01-24' AS Date), 1, 1, 74, 10, 1, 12)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (282, N'Tatuagem', CAST(727.27 AS Decimal(10, 2)), CAST(N'2024-02-24' AS Date), 1, 1, 74, 10, 1, 12)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (283, N'Tatuagem', CAST(727.27 AS Decimal(10, 2)), CAST(N'2024-03-24' AS Date), 1, 1, 74, 10, 1, 12)
    GO
    INSERT [dbo].[despesa] ([id_despesa], [descricao], [valor], [data], [is_paid], [is_parcela], [id_cliente], [id_tipo_despesa], [is_cartao], [id_cartao]) VALUES (284, N'Pix', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-05-11' AS Date), 0, 0, 74, 10, 0, NULL)
    GO
    SET IDENTITY_INSERT [dbo].[despesa] OFF
    GO
    SET IDENTITY_INSERT [dbo].[porquinho] ON
    GO
    INSERT [dbo].[porquinho] ([id_porquinho], [nome], [valor_final], [valor_atual], [is_concluido], [id_cliente]) VALUES (12, N'Faculdade', CAST(1600.01 AS Decimal(10, 2)), CAST(600.00 AS Decimal(10, 2)), 0, 74)
    GO
    INSERT [dbo].[porquinho] ([id_porquinho], [nome], [valor_final], [valor_atual], [is_concluido], [id_cliente]) VALUES (13, N'Viagem', CAST(1000.00 AS Decimal(10, 2)), CAST(0.00 AS Decimal(10, 2)), 0, 74)
    GO
    SET IDENTITY_INSERT [dbo].[porquinho] OFF
    GO
    SET IDENTITY_INSERT [dbo].[receita] ON
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (1, N'Salário', CAST(4000.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (2, N'Salário', CAST(4000.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (3, N'Salário', CAST(4000.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (4, N'Bet 365', CAST(4000.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (5, N'Bet 365', CAST(50000.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 45, 8)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (6, N'Bet 365', CAST(50000.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 45, 8)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (7, N'bolsa', CAST(1900.00 AS Decimal(10, 2)), CAST(N'2023-04-04' AS Date), 54, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (8, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2023-04-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (9, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2023-05-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (10, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2023-06-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (11, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2023-07-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (12, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2023-08-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (13, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2023-09-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (14, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2023-10-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (15, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2023-11-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (16, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2023-12-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (17, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2024-01-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (18, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2024-02-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (19, N'dasdasdas', CAST(150.00 AS Decimal(10, 2)), CAST(N'2024-03-11' AS Date), 45, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (20, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (21, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-05-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (22, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-06-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (23, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-07-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (24, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-08-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (25, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-09-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (26, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-10-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (27, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-11-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (28, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-12-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (29, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2024-01-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (30, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2024-02-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (31, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2024-03-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (32, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (33, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-05-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (34, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-06-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (35, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-07-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (36, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-08-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (37, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-09-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (38, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-10-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (39, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-11-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (40, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2023-12-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (41, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2024-01-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (42, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2024-02-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (43, N'string', CAST(25.00 AS Decimal(10, 2)), CAST(N'2024-03-12' AS Date), 45, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (44, N'Blaze', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 61, 3)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (45, N'Blaze', CAST(500.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 62, 3)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (46, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-04-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (47, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-05-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (48, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-06-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (49, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-07-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (50, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-08-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (51, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-09-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (52, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-10-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (53, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-11-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (54, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-12-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (55, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2024-01-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (56, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2024-02-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (57, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2024-03-12' AS Date), 62, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (58, N'Salário', CAST(2500.00 AS Decimal(10, 2)), CAST(N'2023-04-18' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (59, N'Salário', CAST(2500.00 AS Decimal(10, 2)), CAST(N'2023-04-18' AS Date), 72, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (60, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-04-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (61, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-05-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (62, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-06-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (63, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-07-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (64, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-08-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (65, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-09-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (66, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-10-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (67, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-11-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (68, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-12-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (69, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2024-01-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (70, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2024-02-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (71, N'string', CAST(100.00 AS Decimal(10, 2)), CAST(N'2024-03-24' AS Date), 71, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (72, N'teste dashboard', CAST(1900.00 AS Decimal(10, 2)), CAST(N'2023-04-24' AS Date), 74, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (73, N'teste 02 dashboard', CAST(800.00 AS Decimal(10, 2)), CAST(N'2023-04-24' AS Date), 74, 5)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (74, N'Salário', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 76, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (75, N'dasdas', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 76, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (76, N'das', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 76, 3)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (77, N'DS', CAST(0.50 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 76, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (78, N'', CAST(0.50 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 76, 3)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (80, N'dsadsa', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-04-25' AS Date), 76, 4)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (81, N'Pai', CAST(100.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 74, 6)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (82, N'ddsadasdas', CAST(50.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 76, 9)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (84, N'dasdasdsad', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 76, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (85, N'1', CAST(1.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 76, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (86, N'dsadas', CAST(1000.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 76, 3)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (87, N'aaaa', CAST(111.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 76, 2)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (88, N'fdfd', CAST(333.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 76, 5)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (89, N'asdsd', CAST(444.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 76, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (90, N'Salário', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 80, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (91, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-04-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (92, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-05-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (93, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-06-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (94, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-07-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (95, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-08-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (96, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-09-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (97, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-10-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (98, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-11-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (99, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2023-12-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (100, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2024-01-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (101, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2024-02-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (102, N'Salario', CAST(5000.00 AS Decimal(10, 2)), CAST(N'2024-03-26' AS Date), 81, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (103, N'EY', CAST(1900.00 AS Decimal(10, 2)), CAST(N'2023-04-27' AS Date), 74, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (104, N'Salário top', CAST(1900.00 AS Decimal(10, 2)), CAST(N'2023-04-27' AS Date), 83, 1)
    GO
    INSERT [dbo].[receita] ([id_receita], [descricao], [valor], [data], [id_cliente], [id_tipo_receita]) VALUES (105, N'Sálario', CAST(2000.00 AS Decimal(10, 2)), CAST(N'2023-05-10' AS Date), 74, 1)
    GO
    SET IDENTITY_INSERT [dbo].[receita] OFF
    GO
    SET IDENTITY_INSERT [dbo].[tp_cartao] ON
    GO
    INSERT [dbo].[tp_cartao] ([id_tp_cartao], [descricao]) VALUES (1, N'Crédito')
    GO
    INSERT [dbo].[tp_cartao] ([id_tp_cartao], [descricao]) VALUES (2, N'Débito')
    GO
    SET IDENTITY_INSERT [dbo].[tp_cartao] OFF
    GO
    SET IDENTITY_INSERT [dbo].[tp_despesa] ON
    GO
    INSERT [dbo].[tp_despesa] ([id_tp_despesa], [descricao]) VALUES (1, N'Moradia')
    GO
    INSERT [dbo].[tp_despesa] ([id_tp_despesa], [descricao]) VALUES (2, N'Alimentação')
    GO
    INSERT [dbo].[tp_despesa] ([id_tp_despesa], [descricao]) VALUES (3, N'Transporte')
    GO
    INSERT [dbo].[tp_despesa] ([id_tp_despesa], [descricao]) VALUES (4, N'Saúde')
    GO
    INSERT [dbo].[tp_despesa] ([id_tp_despesa], [descricao]) VALUES (5, N'Educação')
    GO
    INSERT [dbo].[tp_despesa] ([id_tp_despesa], [descricao]) VALUES (6, N'Lazer')
    GO
    INSERT [dbo].[tp_despesa] ([id_tp_despesa], [descricao]) VALUES (7, N'Vestuário')
    GO
    INSERT [dbo].[tp_despesa] ([id_tp_despesa], [descricao]) VALUES (8, N'Dívidas')
    GO
    INSERT [dbo].[tp_despesa] ([id_tp_despesa], [descricao]) VALUES (9, N'Impostos')
    GO
    INSERT [dbo].[tp_despesa] ([id_tp_despesa], [descricao]) VALUES (10, N'Outras')
    GO
    SET IDENTITY_INSERT [dbo].[tp_despesa] OFF
    GO
    SET IDENTITY_INSERT [dbo].[tp_perfil] ON
    GO
    INSERT [dbo].[tp_perfil] ([id_tp_perfil], [nome_perfil]) VALUES (1, N'Desendividamento')
    GO
    INSERT [dbo].[tp_perfil] ([id_tp_perfil], [nome_perfil]) VALUES (2, N'Economizando')
    GO
    INSERT [dbo].[tp_perfil] ([id_tp_perfil], [nome_perfil]) VALUES (3, N'Investindo')
    GO
    INSERT [dbo].[tp_perfil] ([id_tp_perfil], [nome_perfil]) VALUES (4, N'Organizando')
    GO
    INSERT [dbo].[tp_perfil] ([id_tp_perfil], [nome_perfil]) VALUES (5, N'Indefinido')
    GO
    SET IDENTITY_INSERT [dbo].[tp_perfil] OFF
    GO
    SET IDENTITY_INSERT [dbo].[tp_receita] ON
    GO
    INSERT [dbo].[tp_receita] ([id_tp_receita], [descricao]) VALUES (1, N'Salário')
    GO
    INSERT [dbo].[tp_receita] ([id_tp_receita], [descricao]) VALUES (2, N'Rendimentos')
    GO
    INSERT [dbo].[tp_receita] ([id_tp_receita], [descricao]) VALUES (3, N'Vendas de Bens')
    GO
    INSERT [dbo].[tp_receita] ([id_tp_receita], [descricao]) VALUES (4, N'Freelance')
    GO
    INSERT [dbo].[tp_receita] ([id_tp_receita], [descricao]) VALUES (5, N'Aluguel')
    GO
    INSERT [dbo].[tp_receita] ([id_tp_receita], [descricao]) VALUES (6, N'Ajuda financeira')
    GO
    INSERT [dbo].[tp_receita] ([id_tp_receita], [descricao]) VALUES (7, N'Reembolsos')
    GO
    INSERT [dbo].[tp_receita] ([id_tp_receita], [descricao]) VALUES (8, N'Prêmios')
    GO
    INSERT [dbo].[tp_receita] ([id_tp_receita], [descricao]) VALUES (9, N'Outras fontes de receitas')
    GO
    SET IDENTITY_INSERT [dbo].[tp_receita] OFF
    GO
ALTER TABLE [dbo].[cartao]  WITH CHECK ADD FOREIGN KEY([id_cliente])
    REFERENCES [dbo].[cliente] ([id])
    GO
ALTER TABLE [dbo].[cartao]  WITH CHECK ADD FOREIGN KEY([id_cor_cartao])
    REFERENCES [dbo].[cor_cartao] ([id_cor_cartao])
    GO
ALTER TABLE [dbo].[cartao]  WITH CHECK ADD FOREIGN KEY([id_tipo])
    REFERENCES [dbo].[tp_cartao] ([id_tp_cartao])
    GO
ALTER TABLE [dbo].[cliente]  WITH CHECK ADD FOREIGN KEY([id_perfil])
    REFERENCES [dbo].[tp_perfil] ([id_tp_perfil])
    GO
ALTER TABLE [dbo].[despesa]  WITH CHECK ADD FOREIGN KEY([id_cliente])
    REFERENCES [dbo].[cliente] ([id])
    GO
ALTER TABLE [dbo].[despesa]  WITH CHECK ADD FOREIGN KEY([id_tipo_despesa])
    REFERENCES [dbo].[tp_despesa] ([id_tp_despesa])
    GO
ALTER TABLE [dbo].[porquinho]  WITH CHECK ADD FOREIGN KEY([id_cliente])
    REFERENCES [dbo].[cliente] ([id])
    GO
ALTER TABLE [dbo].[receita]  WITH CHECK ADD FOREIGN KEY([id_cliente])
    REFERENCES [dbo].[cliente] ([id])
    GO
ALTER TABLE [dbo].[receita]  WITH CHECK ADD FOREIGN KEY([id_tipo_receita])
    REFERENCES [dbo].[tp_receita] ([id_tp_receita])
    GO
ALTER DATABASE [moca] SET  READ_WRITE
GO
