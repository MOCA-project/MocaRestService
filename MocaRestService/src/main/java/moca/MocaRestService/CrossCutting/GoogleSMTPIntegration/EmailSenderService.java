package moca.MocaRestService.CrossCutting.GoogleSMTPIntegration;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailSenderService implements IEmailSenderService {
    @Autowired private JavaMailSender javaMailSender;
    @Autowired private ResourceLoader resourceLoader;
    @Value("${spring.mail.username}") private String username;
    @Value("${spring.mail.host}") private String host;
    @Value("${spring.mail.password}") private String password;
    @Value("${spring.mail.port}") private int port;

    public String sendSimpleMail(EmailDetails details)
    {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(username);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText("<h1> Oi </h1>");
            mailMessage.setSubject(details.getSubject());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }




    public String sendMail(EmailDetails details) throws Exception {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", Boolean.TRUE);
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", Boolean.TRUE);
        properties.put("mail.smtp.starttls.required", Boolean.TRUE);
        properties.put("mail.smtp.ssl.enable", Boolean.FALSE);
        properties.put("mail.test-connection", Boolean.TRUE);
        properties.put("mail.debug", Boolean.TRUE);

        mailSender.setJavaMailProperties(properties);

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            messageHelper.setFrom(username);
            messageHelper.setTo(details.getRecipient());
            messageHelper.setSubject(details.getSubject());
            messageHelper.setText(getHtml(), true);
            mailSender.send(mimeMessage);
            return "Email enviado com sucesso";
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    private String getHtml() throws IOException {
        return "" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
                "    <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta content=\"telephone=no\" name=\"format-detection\">\n" +
                "    <title></title>\n" +
                "    <!--[if (mso 16)]>\n" +
                "    <style type=\"text/css\">\n" +
                "    a {text-decoration: none;}\n" +
                "    </style>\n" +
                "    <![endif]-->\n" +
                "    <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\n" +
                "    <!--[if gte mso 9]>\n" +
                "<xml>\n" +
                "    <o:OfficeDocumentSettings>\n" +
                "    <o:AllowPNG></o:AllowPNG>\n" +
                "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "    </o:OfficeDocumentSettings>\n" +
                "</xml>\n" +
                "<![endif]-->\n" +
                "    <!--[if !mso]><!-- -->\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Nunito:wght@600&display=swap\" rel=\"stylesheet\">\n" +
                "    <!--<![endif]-->\n" +
                "    <!--[if !mso]><!-- -->\n" +
                "    <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,400i,700,700i\" rel=\"stylesheet\">\n" +
                "    <!--<![endif]-->\n" +
                "</head>\n" +
                "\n" +
                "<body data-new-gr-c-s-loaded=\"14.1080.0\">\n" +
                "    <div class=\"es-wrapper-color\">\n" +
                "        <!--[if gte mso 9]>\n" +
                "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "\t\t\t\t<v:fill type=\"tile\" src=\"https://gfsfom.stripocdn.email/content/guids/CABINET_861941c5b882922e1e6f47d12195f3a092f36bcbf565c69b328778482769960e/images/black_abstract_stone_texture_zoom_virtual_background.jpeg\" color=\"#1A7EF8\" origin=\"0.5, 0\" position=\"0.5, 0\"></v:fill>\n" +
                "\t\t\t</v:background>\n" +
                "\t\t<![endif]-->\n" +
                "        <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" background=\"https://gfsfom.stripocdn.email/content/guids/CABINET_861941c5b882922e1e6f47d12195f3a092f36bcbf565c69b328778482769960e/images/black_abstract_stone_texture_zoom_virtual_background.jpeg\" style=\"background-position: center top;\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td class=\"esd-email-paddings\" valign=\"top\">\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"esd-header-popover es-header\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table bgcolor=\"#ffffff\" class=\"es-header-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"650\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p20\" align=\"left\">\n" +
                "                                                        <!--[if mso]><table width=\"610\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"295\" valign=\"top\"><![endif]-->\n" +
                "                                                        <table cellpadding=\"0\" cellspacing=\"0\" align=\"left\" class=\"es-left\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td width=\"295\" align=\"left\" class=\"esd-container-frame es-m-p20b\">\n" +
                "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\"><a target=\"_blank\"><img class=\"adapt-img\" src=\"https://gfsfom.stripocdn.email/content/guids/CABINET_861941c5b882922e1e6f47d12195f3a092f36bcbf565c69b328778482769960e/images/mocalogo_logotipo_2_XPZ.png\" alt style=\"display: block;\" width=\"70\"></a></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                        <!--[if mso]></td><td width=\"20\"></td><td width=\"295\" valign=\"top\"><![endif]-->\n" +
                "                                                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td width=\"295\" align=\"left\" class=\"esd-container-frame\">\n" +
                "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\"><a target=\"_blank\"><img class=\"adapt-img\" src=\"https://gfsfom.stripocdn.email/content/guids/CABINET_861941c5b882922e1e6f47d12195f3a092f36bcbf565c69b328778482769960e/images/mocalogo_logotipo_2_cgX.png\" alt style=\"display: block;\" width=\"295\"></a></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table class=\"es-content-body\" width=\"650\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p20 es-m-p10b\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"es-m-p0r es-m-p20b esd-container-frame\" width=\"610\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-text es-p10t es-p10b\">\n" +
                "                                                                                        <h1 style=\"color: #1a7ef8; font-size: 44px; font-family: roboto, 'helvetica neue', helvetica, arial, sans-serif;\"><strong>Já organizou as suas<br>finanças hoje?</strong></h1>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img src=\"https://gfsfom.stripocdn.email/content/guids/CABINET_861941c5b882922e1e6f47d12195f3a092f36bcbf565c69b328778482769960e/images/_x33__qVL.png\" alt style=\"display: block;\" class=\"adapt-img\" width=\"335\"></a></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-text es-p15t es-p30b\">\n" +
                "                                                                                        <p style=\"font-family: roboto, 'helvetica neue', helvetica, arial, sans-serif; font-size: 16px;\">Não se esqueça de registrar todas as suas transações financeiras no nosso site para obter um controle mais preciso de suas finanças pessoais. Isso ajudará a evitar gastos desnecessários e a alcançar suas metas financeiras. Além disso, confira regularmente o seu orçamento e revise suas despesas para fazer ajustes conforme necessário.<br><br><strong>Sua saúde financeira agradecerá!</strong></p>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table bgcolor=\"#222222\" class=\"es-footer-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"650\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p25b es-p20r es-p20l\" align=\"left\">\n" +
                "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td width=\"610\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\n" +
                "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #1a7ef8; border-radius: 6px; border-collapse: separate;\" bgcolor=\"#1A7EF8\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-text es-m-txt-c es-p20t es-p15b es-p15r es-p15l\">\n" +
                "                                                                                        <h2 style=\"color: #ffffff;\">Esse e-mail foi útil para você?</h2>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-menu\" esd-tmp-menu-padding=\"10|20\" esd-tmp-menu-size=\"width|50\">\n" +
                "                                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"es-menu\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr class=\"images\">\n" +
                "                                                                                                    <td align=\"right\" valign=\"top\" width=\"10%\" class=\"es-p10t es-p10b es-p5r es-p5l\" style=\"padding-bottom: 20px;\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img src=\"https://gfsfom.stripocdn.email/content/guids/CABINET_23b1692267fd44d9d629bde882ff4acc/images/smilingfacewithhearteyes_1f60d_2.png\" alt=\"Item1\" title=\"Item1\" width=\"50\"></a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" width=\"10%\" class=\"es-p10t es-p10b es-p5r es-p5l\" style=\"padding-bottom: 20px;\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img src=\"https://gfsfom.stripocdn.email/content/guids/CABINET_23b1692267fd44d9d629bde882ff4acc/images/neutralface_1f610.png\" alt=\"Item2\" title=\"Item2\" width=\"50\"></a></td>\n" +
                "                                                                                                    <td align=\"left\" valign=\"top\" width=\"10%\" class=\"es-p10t es-p10b es-p5r es-p5l\" style=\"padding-bottom: 20px;\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img src=\"https://gfsfom.stripocdn.email/content/guids/CABINET_23b1692267fd44d9d629bde882ff4acc/images/sadbutrelievedface_1f625.png\" alt=\"Item3\" title=\"Item3\" width=\"50\"></a></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table bgcolor=\"#f7fff7\" class=\"es-footer-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"650\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p30t es-p30b es-p20r es-p20l\" align=\"left\">\n" +
                "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td width=\"610\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\n" +
                "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-social es-p15b\" style=\"font-size:0\">\n" +
                "                                                                                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-table-not-adapt es-social\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" class=\"es-p40r\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img title=\"Facebook\" src=\"https://gfsfom.stripocdn.email/content/assets/img/social-icons/logo-black/facebook-logo-black.png\" alt=\"Fb\" height=\"24\"></a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" class=\"es-p40r\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img title=\"Twitter\" src=\"https://gfsfom.stripocdn.email/content/assets/img/social-icons/logo-black/twitter-logo-black.png\" alt=\"Tw\" height=\"24\"></a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" class=\"es-p40r\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img title=\"Instagram\" src=\"https://gfsfom.stripocdn.email/content/assets/img/social-icons/logo-black/instagram-logo-black.png\" alt=\"Inst\" height=\"24\"></a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img title=\"Youtube\" src=\"https://gfsfom.stripocdn.email/content/assets/img/social-icons/logo-black/youtube-logo-black.png\" alt=\"Yt\" height=\"24\"></a></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-text\">\n" +
                "                                                                                        <p>Copyright © 2023 Moca</p>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content esd-footer-popover\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"650\" style=\"background-color: transparent;\" bgcolor=\"#ffffff\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p20\" align=\"left\">\n" +
                "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td width=\"610\" class=\"esd-container-frame\" align=\"left\">\n" +
                "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-empty-container\" style=\"display: none;\"></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</body>\n" +
                "\n" +
                "</html>\n" +
                "\n" +
                "<style>\n" +
                "    /* CONFIG STYLES Please do not delete and edit CSS styles below */\n" +
                "/* IMPORTANT THIS STYLES MUST BE ON FINAL EMAIL */\n" +
                ".rollover div {\n" +
                "    font-size: 0;\n" +
                "}\n" +
                "\n" +
                ".rollover:hover .rollover-first {\n" +
                "    max-height: 0px !important;\n" +
                "    display: none !important;\n" +
                "}\n" +
                "\n" +
                ".rollover:hover .rollover-second {\n" +
                "    max-height: none !important;\n" +
                "    display: block !important;\n" +
                "}\n" +
                "\n" +
                "#outlook a {\n" +
                "    padding: 0;\n" +
                "}\n" +
                "\n" +
                ".es-button {\n" +
                "    mso-style-priority: 100 !important;\n" +
                "    text-decoration: none !important;\n" +
                "}\n" +
                "\n" +
                "a[x-apple-data-detectors] {\n" +
                "    color: inherit !important;\n" +
                "    text-decoration: none !important;\n" +
                "    font-size: inherit !important;\n" +
                "    font-family: inherit !important;\n" +
                "    font-weight: inherit !important;\n" +
                "    line-height: inherit !important;\n" +
                "}\n" +
                "\n" +
                ".es-desk-hidden {\n" +
                "    display: none;\n" +
                "    float: left;\n" +
                "    overflow: hidden;\n" +
                "    width: 0;\n" +
                "    max-height: 0;\n" +
                "    line-height: 0;\n" +
                "    mso-hide: all;\n" +
                "}\n" +
                "\n" +
                "/*\n" +
                "END OF IMPORTANT\n" +
                "*/\n" +
                "body {\n" +
                "    width: 100%;\n" +
                "    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol';\n" +
                "    -webkit-text-size-adjust: 100%;\n" +
                "    -ms-text-size-adjust: 100%;\n" +
                "}\n" +
                "\n" +
                "table {\n" +
                "    mso-table-lspace: 0pt;\n" +
                "    mso-table-rspace: 0pt;\n" +
                "    border-collapse: collapse;\n" +
                "    border-spacing: 0px;\n" +
                "}\n" +
                "\n" +
                "table td,\n" +
                "body,\n" +
                ".es-wrapper {\n" +
                "    padding: 0;\n" +
                "    Margin: 0;\n" +
                "}\n" +
                "\n" +
                ".es-content,\n" +
                ".es-header,\n" +
                ".es-footer {\n" +
                "    table-layout: fixed !important;\n" +
                "    width: 100%;\n" +
                "}\n" +
                "\n" +
                "img {\n" +
                "    display: block;\n" +
                "    border: 0;\n" +
                "    outline: none;\n" +
                "    text-decoration: none;\n" +
                "    -ms-interpolation-mode: bicubic;\n" +
                "}\n" +
                "\n" +
                "p,\n" +
                "hr {\n" +
                "    Margin: 0;\n" +
                "}\n" +
                "\n" +
                "h1,\n" +
                "h2,\n" +
                "h3,\n" +
                "h4,\n" +
                "h5 {\n" +
                "    Margin: 0;\n" +
                "    line-height: 120%;\n" +
                "    mso-line-height-rule: exactly;\n" +
                "    font-family: Nunito, Roboto, sans-serif;\n" +
                "}\n" +
                "\n" +
                "p,\n" +
                "ul li,\n" +
                "ol li,\n" +
                "a {\n" +
                "    -webkit-text-size-adjust: none;\n" +
                "    -ms-text-size-adjust: none;\n" +
                "    mso-line-height-rule: exactly;\n" +
                "}\n" +
                "\n" +
                ".es-left {\n" +
                "    float: left;\n" +
                "}\n" +
                "\n" +
                ".es-right {\n" +
                "    float: right;\n" +
                "}\n" +
                "\n" +
                ".es-p5 {\n" +
                "    padding: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5t {\n" +
                "    padding-top: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5b {\n" +
                "    padding-bottom: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5l {\n" +
                "    padding-left: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p5r {\n" +
                "    padding-right: 5px;\n" +
                "}\n" +
                "\n" +
                ".es-p10 {\n" +
                "    padding: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10t {\n" +
                "    padding-top: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10b {\n" +
                "    padding-bottom: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10l {\n" +
                "    padding-left: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p10r {\n" +
                "    padding-right: 10px;\n" +
                "}\n" +
                "\n" +
                ".es-p15 {\n" +
                "    padding: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15t {\n" +
                "    padding-top: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15b {\n" +
                "    padding-bottom: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15l {\n" +
                "    padding-left: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p15r {\n" +
                "    padding-right: 15px;\n" +
                "}\n" +
                "\n" +
                ".es-p20 {\n" +
                "    padding: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20t {\n" +
                "    padding-top: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20b {\n" +
                "    padding-bottom: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20l {\n" +
                "    padding-left: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p20r {\n" +
                "    padding-right: 20px;\n" +
                "}\n" +
                "\n" +
                ".es-p25 {\n" +
                "    padding: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25t {\n" +
                "    padding-top: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25b {\n" +
                "    padding-bottom: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25l {\n" +
                "    padding-left: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p25r {\n" +
                "    padding-right: 25px;\n" +
                "}\n" +
                "\n" +
                ".es-p30 {\n" +
                "    padding: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30t {\n" +
                "    padding-top: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30b {\n" +
                "    padding-bottom: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30l {\n" +
                "    padding-left: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p30r {\n" +
                "    padding-right: 30px;\n" +
                "}\n" +
                "\n" +
                ".es-p35 {\n" +
                "    padding: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35t {\n" +
                "    padding-top: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35b {\n" +
                "    padding-bottom: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35l {\n" +
                "    padding-left: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p35r {\n" +
                "    padding-right: 35px;\n" +
                "}\n" +
                "\n" +
                ".es-p40 {\n" +
                "    padding: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40t {\n" +
                "    padding-top: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40b {\n" +
                "    padding-bottom: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40l {\n" +
                "    padding-left: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-p40r {\n" +
                "    padding-right: 40px;\n" +
                "}\n" +
                "\n" +
                ".es-menu td {\n" +
                "    border: 0;\n" +
                "}\n" +
                "\n" +
                ".es-menu td a img {\n" +
                "    display: inline-block !important;\n" +
                "    vertical-align: middle;\n" +
                "}\n" +
                "\n" +
                "/*\n" +
                "END CONFIG STYLES\n" +
                "*/\n" +
                "s {\n" +
                "    text-decoration: line-through;\n" +
                "}\n" +
                "\n" +
                "p,\n" +
                "ul li,\n" +
                "ol li {\n" +
                "    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol';\n" +
                "    line-height: 150%;\n" +
                "}\n" +
                "\n" +
                "ul li,\n" +
                "ol li {\n" +
                "    margin-left: 0;\n" +
                "    margin-bottom: 15px;\n" +
                "}\n" +
                "\n" +
                "a {\n" +
                "    text-decoration: underline;\n" +
                "}\n" +
                "\n" +
                ".es-menu td a {\n" +
                "    text-decoration: none;\n" +
                "    display: block;\n" +
                "    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol';\n" +
                "}\n" +
                "\n" +
                ".es-wrapper {\n" +
                "    width: 100%;\n" +
                "    height: 100%;\n" +
                "    background-image: url('https://gfsfom.stripocdn.email/content/guids/CABINET_861941c5b882922e1e6f47d12195f3a092f36bcbf565c69b328778482769960e/images/black_abstract_stone_texture_zoom_virtual_background.jpeg');\n" +
                "    background-repeat: repeat;\n" +
                "    background-position: center top;\n" +
                "}\n" +
                "\n" +
                ".es-wrapper-color,\n" +
                ".es-wrapper {\n" +
                "    background-color: #1A7EF8;\n" +
                "}\n" +
                "\n" +
                ".es-header {\n" +
                "    background-color: transparent;\n" +
                "    background-image: ;\n" +
                "    background-repeat: repeat;\n" +
                "    background-position: center top;\n" +
                "}\n" +
                "\n" +
                ".es-header-body {\n" +
                "    background-color: #ffffff;\n" +
                "}\n" +
                "\n" +
                ".es-header-body p,\n" +
                ".es-header-body ul li,\n" +
                ".es-header-body ol li {\n" +
                "    color: #333333;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-header-body a {\n" +
                "    color: #333333;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-content-body {\n" +
                "    background-color: #ffffff;\n" +
                "}\n" +
                "\n" +
                ".es-content-body p,\n" +
                ".es-content-body ul li,\n" +
                ".es-content-body ol li {\n" +
                "    color: #333333;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-content-body a {\n" +
                "    color: #333333;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-footer {\n" +
                "    background-color: transparent;\n" +
                "    background-image: ;\n" +
                "    background-repeat: repeat;\n" +
                "    background-position: center top;\n" +
                "}\n" +
                "\n" +
                ".es-footer-body {\n" +
                "    background-color: #ffffff;\n" +
                "}\n" +
                "\n" +
                ".es-footer-body p,\n" +
                ".es-footer-body ul li,\n" +
                ".es-footer-body ol li {\n" +
                "    color: #333333;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-footer-body a {\n" +
                "    color: #333333;\n" +
                "    font-size: 14px;\n" +
                "}\n" +
                "\n" +
                ".es-infoblock,\n" +
                ".es-infoblock p,\n" +
                ".es-infoblock ul li,\n" +
                ".es-infoblock ol li {\n" +
                "    line-height: 120%;\n" +
                "    font-size: 12px;\n" +
                "    color: #cccccc;\n" +
                "}\n" +
                "\n" +
                ".es-infoblock a {\n" +
                "    font-size: 12px;\n" +
                "    color: #cccccc;\n" +
                "}\n" +
                "\n" +
                "h1 {\n" +
                "    font-size: 46px;\n" +
                "    font-style: normal;\n" +
                "    font-weight: normal;\n" +
                "    color: #11486D;\n" +
                "}\n" +
                "\n" +
                "h2 {\n" +
                "    font-size: 28px;\n" +
                "    font-style: normal;\n" +
                "    font-weight: normal;\n" +
                "    color: #11486D;\n" +
                "}\n" +
                "\n" +
                "h3 {\n" +
                "    font-size: 20px;\n" +
                "    font-style: normal;\n" +
                "    font-weight: normal;\n" +
                "    color: #11486D;\n" +
                "}\n" +
                "\n" +
                ".es-header-body h1 a,\n" +
                ".es-content-body h1 a,\n" +
                ".es-footer-body h1 a {\n" +
                "    font-size: 46px;\n" +
                "}\n" +
                "\n" +
                ".es-header-body h2 a,\n" +
                ".es-content-body h2 a,\n" +
                ".es-footer-body h2 a {\n" +
                "    font-size: 28px;\n" +
                "}\n" +
                "\n" +
                ".es-header-body h3 a,\n" +
                ".es-content-body h3 a,\n" +
                ".es-footer-body h3 a {\n" +
                "    font-size: 20px;\n" +
                "}\n" +
                "\n" +
                "a.es-button,\n" +
                "button.es-button {\n" +
                "    display: inline-block;\n" +
                "    background: #0098D0;\n" +
                "    border-radius: 30px;\n" +
                "    font-size: 18px;\n" +
                "    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol';\n" +
                "    font-weight: normal;\n" +
                "    font-style: normal;\n" +
                "    line-height: 120%;\n" +
                "    color: #ffffff;\n" +
                "    text-decoration: none;\n" +
                "    width: auto;\n" +
                "    text-align: center;\n" +
                "    padding: 10px 20px 10px 20px;\n" +
                "}\n" +
                "\n" +
                ".es-button-border {\n" +
                "    border-style: solid solid solid solid;\n" +
                "    border-color: #2cb543 #2cb543 #2cb543 #2cb543;\n" +
                "    background: #0098D0;\n" +
                "    border-width: 0px 0px 0px 0px;\n" +
                "    display: inline-block;\n" +
                "    border-radius: 30px;\n" +
                "    width: auto;\n" +
                "    mso-border-alt: 10px;\n" +
                "}\n" +
                "\n" +
                ".msohide {\n" +
                "    mso-hide: all;\n" +
                "}\n" +
                "\n" +
                "/* RESPONSIVE STYLES Please do not delete and edit CSS styles below. If you don't need responsive layout, please delete this section. */\n" +
                "@media only screen and (max-width: 600px) {\n" +
                "\n" +
                "    p,\n" +
                "    ul li,\n" +
                "    ol li,\n" +
                "    a {\n" +
                "        line-height: 150% !important;\n" +
                "    }\n" +
                "\n" +
                "    h1,\n" +
                "    h2,\n" +
                "    h3,\n" +
                "    h1 a,\n" +
                "    h2 a,\n" +
                "    h3 a {\n" +
                "        line-height: 120%;\n" +
                "    }\n" +
                "\n" +
                "    h1 {\n" +
                "        font-size: 46px !important;\n" +
                "        text-align: center !important;\n" +
                "    }\n" +
                "\n" +
                "    h2 {\n" +
                "        font-size: 28px !important;\n" +
                "        text-align: center !important;\n" +
                "    }\n" +
                "\n" +
                "    h3 {\n" +
                "        font-size: 20px !important;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "\n" +
                "    .es-header-body h1 a,\n" +
                "    .es-content-body h1 a,\n" +
                "    .es-footer-body h1 a {\n" +
                "        font-size: 46px !important;\n" +
                "        text-align: center !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-header-body h2 a,\n" +
                "    .es-content-body h2 a,\n" +
                "    .es-footer-body h2 a {\n" +
                "        font-size: 28px !important;\n" +
                "        text-align: center !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-header-body h3 a,\n" +
                "    .es-content-body h3 a,\n" +
                "    .es-footer-body h3 a {\n" +
                "        font-size: 20px !important;\n" +
                "        text-align: center;\n" +
                "    }\n" +
                "\n" +
                "    .es-menu td a {\n" +
                "        font-size: 14px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-header-body p,\n" +
                "    .es-header-body ul li,\n" +
                "    .es-header-body ol li,\n" +
                "    .es-header-body a {\n" +
                "        font-size: 14px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-content-body p,\n" +
                "    .es-content-body ul li,\n" +
                "    .es-content-body ol li,\n" +
                "    .es-content-body a {\n" +
                "        font-size: 14px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-footer-body p,\n" +
                "    .es-footer-body ul li,\n" +
                "    .es-footer-body ol li,\n" +
                "    .es-footer-body a {\n" +
                "        font-size: 14px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-infoblock p,\n" +
                "    .es-infoblock ul li,\n" +
                "    .es-infoblock ol li,\n" +
                "    .es-infoblock a {\n" +
                "        font-size: 12px !important;\n" +
                "    }\n" +
                "\n" +
                "    *[class=\"gmail-fix\"] {\n" +
                "        display: none !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-txt-c,\n" +
                "    .es-m-txt-c h1,\n" +
                "    .es-m-txt-c h2,\n" +
                "    .es-m-txt-c h3 {\n" +
                "        text-align: center !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-txt-r,\n" +
                "    .es-m-txt-r h1,\n" +
                "    .es-m-txt-r h2,\n" +
                "    .es-m-txt-r h3 {\n" +
                "        text-align: right !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-txt-l,\n" +
                "    .es-m-txt-l h1,\n" +
                "    .es-m-txt-l h2,\n" +
                "    .es-m-txt-l h3 {\n" +
                "        text-align: left !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-txt-r img,\n" +
                "    .es-m-txt-c img,\n" +
                "    .es-m-txt-l img {\n" +
                "        display: inline !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-button-border {\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "\n" +
                "    a.es-button,\n" +
                "    button.es-button {\n" +
                "        font-size: 18px !important;\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-adaptive table,\n" +
                "    .es-left,\n" +
                "    .es-right {\n" +
                "        width: 100% !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-content table,\n" +
                "    .es-header table,\n" +
                "    .es-footer table,\n" +
                "    .es-content,\n" +
                "    .es-footer,\n" +
                "    .es-header {\n" +
                "        width: 100% !important;\n" +
                "        max-width: 600px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-adapt-td {\n" +
                "        display: block !important;\n" +
                "        width: 100% !important;\n" +
                "    }\n" +
                "\n" +
                "    .adapt-img {\n" +
                "        width: 100% !important;\n" +
                "        height: auto !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p0 {\n" +
                "        padding: 0 !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p0r {\n" +
                "        padding-right: 0 !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p0l {\n" +
                "        padding-left: 0 !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p0t {\n" +
                "        padding-top: 0 !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p0b {\n" +
                "        padding-bottom: 0 !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p20b {\n" +
                "        padding-bottom: 20px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-mobile-hidden,\n" +
                "    .es-hidden {\n" +
                "        display: none !important;\n" +
                "    }\n" +
                "\n" +
                "    tr.es-desk-hidden,\n" +
                "    td.es-desk-hidden,\n" +
                "    table.es-desk-hidden {\n" +
                "        width: auto !important;\n" +
                "        overflow: visible !important;\n" +
                "        float: none !important;\n" +
                "        max-height: inherit !important;\n" +
                "        line-height: inherit !important;\n" +
                "    }\n" +
                "\n" +
                "    tr.es-desk-hidden {\n" +
                "        display: table-row !important;\n" +
                "    }\n" +
                "\n" +
                "    table.es-desk-hidden {\n" +
                "        display: table !important;\n" +
                "    }\n" +
                "\n" +
                "    td.es-desk-menu-hidden {\n" +
                "        display: table-cell !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-menu td {\n" +
                "        width: 1% !important;\n" +
                "    }\n" +
                "\n" +
                "    table.es-table-not-adapt,\n" +
                "    .esd-block-html table {\n" +
                "        width: auto !important;\n" +
                "    }\n" +
                "\n" +
                "    table.es-social {\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "\n" +
                "    table.es-social td {\n" +
                "        display: inline-block !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-desk-hidden {\n" +
                "        display: table-row !important;\n" +
                "        width: auto !important;\n" +
                "        overflow: visible !important;\n" +
                "        max-height: inherit !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p5 {\n" +
                "        padding: 5px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p5t {\n" +
                "        padding-top: 5px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p5b {\n" +
                "        padding-bottom: 5px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p5r {\n" +
                "        padding-right: 5px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p5l {\n" +
                "        padding-left: 5px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p10 {\n" +
                "        padding: 10px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p10t {\n" +
                "        padding-top: 10px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p10b {\n" +
                "        padding-bottom: 10px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p10r {\n" +
                "        padding-right: 10px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p10l {\n" +
                "        padding-left: 10px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p15 {\n" +
                "        padding: 15px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p15t {\n" +
                "        padding-top: 15px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p15b {\n" +
                "        padding-bottom: 15px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p15r {\n" +
                "        padding-right: 15px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p15l {\n" +
                "        padding-left: 15px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p20 {\n" +
                "        padding: 20px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p20t {\n" +
                "        padding-top: 20px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p20r {\n" +
                "        padding-right: 20px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p20l {\n" +
                "        padding-left: 20px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p25 {\n" +
                "        padding: 25px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p25t {\n" +
                "        padding-top: 25px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p25b {\n" +
                "        padding-bottom: 25px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p25r {\n" +
                "        padding-right: 25px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p25l {\n" +
                "        padding-left: 25px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p30 {\n" +
                "        padding: 30px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p30t {\n" +
                "        padding-top: 30px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p30b {\n" +
                "        padding-bottom: 30px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p30r {\n" +
                "        padding-right: 30px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p30l {\n" +
                "        padding-left: 30px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p35 {\n" +
                "        padding: 35px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p35t {\n" +
                "        padding-top: 35px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p35b {\n" +
                "        padding-bottom: 35px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p35r {\n" +
                "        padding-right: 35px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p35l {\n" +
                "        padding-left: 35px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p40 {\n" +
                "        padding: 40px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p40t {\n" +
                "        padding-top: 40px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p40b {\n" +
                "        padding-bottom: 40px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p40r {\n" +
                "        padding-right: 40px !important;\n" +
                "    }\n" +
                "\n" +
                "    .es-m-p40l {\n" +
                "        padding-left: 40px !important;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "/* END RESPONSIVE STYLES */\n" +
                "html,\n" +
                "body {\n" +
                "    font-family: arial, 'helvetica neue', helvetica, sans-serif;\n" +
                "}\n" +
                "</style>";
    }
}
